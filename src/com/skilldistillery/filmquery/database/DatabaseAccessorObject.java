package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String pass = "student";

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		String stmt = "SELECT * FROM film WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement preStmt = conn.prepareStatement(stmt);
			preStmt.setInt(1, filmId);
			ResultSet newFilm = preStmt.executeQuery();
			while (newFilm.next()) {
				film = new Film();
				film.setId(newFilm.getInt("id"));
				film.setTitle(newFilm.getString("title"));
				film.setDescription(newFilm.getString("description"));
				film.setReleaseYear(newFilm.getInt("release_year"));
				film.setLanguageId(newFilm.getInt("language_id"));
				film.setDuration(newFilm.getInt("rental_duration"));
				film.setRentRate(newFilm.getDouble("rental_rate"));
				film.setLength(newFilm.getInt("length"));
				film.setReplaceCost(newFilm.getDouble("replacement_cost"));
				film.setRating(newFilm.getString("rating"));
				film.setSpecialFeatures(newFilm.getString("special_features"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		String stmt = "SELECT * FROM actor WHERE actor_id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement preStmt = conn.prepareStatement(stmt);
			preStmt.setInt(1, actorId);
			ResultSet newFilm = preStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		Actor actor = null;
		String stmt = "SELECT * FROM film WHERE actor_id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement preStmt = conn.prepareStatement(stmt);
			preStmt.setInt(1, filmId);
			ResultSet newFilm = preStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actors;
	}

}
