package com.example.lab5_servlet;

import com.example.lab4.Album;
import com.example.lab4.Artist;
import com.example.lab4.Composition;
import com.example.lab5.service.AlbumService;
import com.example.lab5.service.ArtistService;
import com.example.lab5.service.CompositionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/compositions")
public class CompositionController extends HttpServlet {
    private ArtistService artistService;
    private AlbumService albumService;
    private CompositionService compositionService;

    @Override
    public void init() throws ServletException {
        artistService = new ArtistService();
        albumService = new AlbumService();
        compositionService = new CompositionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "addToArtist":
                addComposition(req, resp);
                break;
            case "addToAlbum":
                addCompositionAtAlbum(req, resp);
                break;
            case "all":
                showAllComposition(req, resp);
                break;
            case "showById":
                showCompositionById(req, resp);
                break;
            case "showByName":
                getCompositionByName(req, resp);
                break;
            case "update":
                updateComposition(req, resp);
                break;
            case "remove":
                removeComposition(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void showAllComposition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Composition> compositions = compositionService.getAllCompositions();
        req.setAttribute("compositions", compositions);
        req.getRequestDispatcher("/show-compositions.jsp").forward(req, resp);
    }

    private void addComposition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Double duration = Double.parseDouble(req.getParameter("duration"));
        int id = Integer.parseInt(req.getParameter("id"));
        Artist artist = artistService.getArtistById(id);
        Composition composition = Composition.builder()
                .name(name)
                .duration(duration)
                .build();
        composition.setArtist(artist);
        compositionService.addComposition(composition);
        showAllComposition(req, resp);
    }

    private void addCompositionAtAlbum(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Double duration = Double.parseDouble(req.getParameter("duration"));
        int idArtist = Integer.parseInt(req.getParameter("idArtist"));
        int idAlbum = Integer.parseInt(req.getParameter("idAlbum"));
        Artist artist = artistService.getArtistById(idArtist);
        Album album = albumService.getAlbumById(idAlbum);
        Composition composition = Composition.builder()
                .name(name)
                .duration(duration)
                .build();
        composition.setArtist(artist);
        composition.setAlbum(album);
        compositionService.addComposition(composition);
        showAllComposition(req, resp);
    }

    private void showCompositionById(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Composition composition = compositionService.getCompositionById(id);
        req.setAttribute("compositionName", composition.getName());
        req.setAttribute("compositionDuration", composition.getDuration());
        req.getRequestDispatcher("/show-composition-by-id.jsp").forward(req, resp);
    }

    private void getCompositionByName(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String name = req.getParameter("name");
        List<Composition> compositions = compositionService.getAllCompositions();
        compositions = compositions.stream().filter(composition -> composition.getName().equals(name)).toList();
        req.setAttribute("compositions", compositions);
        req.getRequestDispatcher("show-compositions.jsp").forward(req, resp);
    }

    private void updateComposition(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Double duration = Double.parseDouble(req.getParameter("duration"));
        Composition composition = compositionService.getCompositionById(id);
        composition.setName(name);
        composition.setDuration(duration);
        compositionService.updateComposition(composition);
        showAllComposition(req, resp);
    }

    private void removeComposition(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Composition composition = compositionService.getCompositionById(id);
        compositionService.removeComposition(composition);
        showAllComposition(req, resp);
    }
}
