package com.example.lab5_servlet;

import com.example.lab4.Album;
import com.example.lab4.Artist;
import com.example.lab4.Composition;
import com.example.lab5.service.AlbumService;
import com.example.lab5.service.ArtistService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/albums")
public class AlbumController extends HttpServlet {
    private AlbumService albumService;
    private ArtistService artistService;

    @Override
    public void init() throws ServletException {
        albumService = new AlbumService();
        artistService = new ArtistService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                addAlbum(req, resp);
                break;
            case "showById":
                getAlbumById(req, resp);
                break;
            case "showByName":
                getAlbumByName(req, resp);
                break;
            case "showByGenre":
                getAlbumByGenre(req, resp);
                break;
            case "all":
                showAllAlbums(req, resp);
                break;
            case "showAllCompositions":
                getAllCompositions(req, resp);
                break;
            case "update":
                updateAlbum(req, resp);
                break;
            case "remove":
                removeAlbum(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void addAlbum(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String genre = req.getParameter("genre");
        Artist artist = artistService.getArtistById(id);
        Album album = Album.builder()
                .name(name)
                .genre(genre)
                .build();
        album.setArtist(artist);
        albumService.addAlbum(album);
        showAllAlbums(req, resp);
    }

    private void showAllAlbums(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        List<Album> albums = albumService.getAllAlbums();
        req.setAttribute("albums", albums);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/show-albums.jsp");
        dispatcher.forward(req, resp);
    }

    private void getAlbumById(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Album album = albumService.getAlbumById(id);
        req.setAttribute("id", id);
        req.setAttribute("name", album.getName());
        req.setAttribute("genre", album.getGenre());
        req.getRequestDispatcher("/show-album-by-id.jsp").forward(req, resp);
    }

    private void getAlbumByName(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String name = req.getParameter("name");
        List<Album> albums = albumService.getAllAlbums();
        albums = albums.stream().filter(album -> album.getName().equals(name)).toList();
        req.setAttribute("albums", albums);
        req.getRequestDispatcher("show-albums.jsp").forward(req, resp);
    }

    private void getAlbumByGenre(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String genre = req.getParameter("genre");
        List<Album> albums = albumService.getAllAlbums();
        albums = albums.stream().filter(album -> album.getGenre().equals(genre)).toList();
        req.setAttribute("albums", albums);
        req.getRequestDispatcher("show-albums.jsp").forward(req, resp);
    }

    private void getAllCompositions(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Composition> compositions = albumService.getAllCompositionsOfAlbum(id);
        req.setAttribute("compositions", compositions);
        req.getRequestDispatcher("show-compositions.jsp").forward(req, resp);
    }

    private void updateAlbum(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String genre = req.getParameter("genre");
        Album album = albumService.getAlbumById(id);
        album.setName(name);
        album.setGenre(genre);
        albumService.updateAlbum(album);
        showAllAlbums(req, resp);
    }

    private void removeAlbum(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Album album = albumService.getAlbumById(id);
        albumService.removeAlbum(album);
        showAllAlbums(req, resp);
    }
}

