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
		String stmt = "SELECT film.*, language.name FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";
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
				film.setLanguage(newFilm.getString("name"));
				film.setActors(findActorsByFilmId(filmId));
				
			}
			newFilm.close();
			preStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}
	@Override
	public List<Film> findWithKeyWord(String keyword) {
		List<Film> films = new ArrayList<>();
		Film film = null;
		String stmt = "SELECT film.*, language.name FROM film JOIN language ON film.language_id = language.id WHERE film.title LIKE ? OR film.description LIKE ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement preStmt = conn.prepareStatement(stmt);
			String keyword2 = "%" + keyword + "%";
			preStmt.setString(1, keyword2);
			preStmt.setString(2, keyword2);
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
				film.setLanguage(newFilm.getString("name"));
				film.setActors(findActorsByFilmId(newFilm.getInt("id")));
				films.add(film);
				
			}
			newFilm.close();
			preStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}
	
	
	
	
	
	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		String stmt = "SELECT * FROM actor WHERE id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement preStmt = conn.prepareStatement(stmt);
			preStmt.setInt(1, actorId);
			ResultSet newActor = preStmt.executeQuery();
			while(newActor.next()) {
				actor = new Actor();
			actor.setActorId(newActor.getInt("id"));
			actor.setActorFirstName(newActor.getString("first_name"));
			actor.setActorLastName(newActor.getString("last_name"));
			}
			newActor.close();
			preStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		Actor actor = null;
		String stmt = "SELECT id, first_name, last_name FROM actor JOIN film_actor fa ON fa.actor_id = actor.id WHERE film_id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement preStmt = conn.prepareStatement(stmt);
			preStmt.setInt(1, filmId);
			ResultSet newActors = preStmt.executeQuery();
			while(newActors.next()) {
				actor = new Actor();
				actor.setActorId(newActors.getInt("id"));
				actor.setActorFirstName(newActors.getString("first_name"));
				actor.setActorLastName(newActors.getString("last_name"));
				actors.add(actor);
			}
			newActors.close();
			preStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actors;
	}

}
