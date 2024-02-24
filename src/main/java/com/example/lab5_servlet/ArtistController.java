package com.example.lab5_servlet;

import com.example.lab4.Album;
import com.example.lab4.Artist;
import com.example.lab5.service.ArtistService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/artists")
public class ArtistController extends HttpServlet {
    private ArtistService artistService;

    @Override
    public void init() throws ServletException {
        artistService = new ArtistService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("action");
        switch (key) {
            case "addShort":
                addArtistWithName(req, resp);
                break;
            case "addLong":
                addArtistWithNameAndSurname(req, resp);
                break;
            case "showById":
                showArtistById(req, resp);
                break;
            case "updateArtistName":
                updateArtistName(req, resp);
                break;
            case "updateArtistNameAndSurname":
                updateArtistNameAndSurname(req, resp);
                break;
            case "remove":
                removeArtist(req, resp);
                break;
            case "showAlbumsOfArtist":
                showAllAlbumsOfArtist(req, resp);
                break;
            case "all":
                showAllArtists(req, resp);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    private void addArtistWithName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Artist artist = Artist.builder()
                .name(name)
                .build();
        artistService.addArtist(artist);
        showAllArtists(req, resp);
    }

    private void addArtistWithNameAndSurname(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        Artist artist = Artist.builder()
                .name(name)
                .surname(surname)
                .build();
        artistService.addArtist(artist);
        showAllArtists(req, resp);
    }

    private void showAllArtists(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        List<Artist> artists = artistService.getAllArtists();
        req.setAttribute("artists", artists);
        req.getRequestDispatcher("/show-artists.jsp").forward(req, resp);
    }

    private void showArtistById(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String id = req.getParameter("id");
        Artist artistById = artistService.getArtistById(Integer.parseInt(id));
        req.setAttribute("artistName", artistById.getName());
        req.setAttribute("artistSurname", artistById.getSurname());
        req.getRequestDispatcher("/show-by-id.jsp").forward(req, resp);
    }

    private void updateArtistName(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Artist artist = artistService.getArtistById(id);
        artist.setName(name);
        artistService.updateArtist(artist);
        showAllArtists(req, resp);
    }

    private void updateArtistNameAndSurname(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        Artist artist = artistService.getArtistById(id);
        artist.setName(name);
        artist.setSurname(surname);
        artistService.updateArtist(artist);
        showAllArtists(req, resp);
    }

    private void removeArtist(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Artist artist = artistService.getArtistById(id);
        artistService.removeArtist(artist);
        showAllArtists(req, resp);
    }

    private void showAllAlbumsOfArtist(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Artist artist = artistService.getArtistById(id);
        List<Album> allAlbumsOfArtist = artistService.getAllAlbumsOfArtist(id);
        req.setAttribute("artistName", artist.getName());
        req.setAttribute("artistSurname", artist.getSurname());
        req.setAttribute("albums", allAlbumsOfArtist);
        req.getRequestDispatcher("/show-albums-of-artist.jsp").forward(req, resp);
    }
}
