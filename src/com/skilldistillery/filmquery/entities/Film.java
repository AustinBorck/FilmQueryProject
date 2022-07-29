package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private int duration;
	private double rentRate;
	private int length;
	private double replaceCost;
	private String rating;
	private String specialFeatures;
	private String language;
	private List<Actor> actors = new ArrayList<>();

//NO ARGS CONSTRUCTOR
	public Film() {
		super();
	}
//FULL ARGS CONSTRUCTOR
public Film(int id, String title, String description, int releaseYear, int languageId, int duration,
			double rentRate, int length, double replaceCost, String rating, String specialFeatures, String language,
			List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.duration = duration;
		this.rentRate = rentRate;
		this.length = length;
		this.replaceCost = replaceCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.language = language;
		this.actors = actors;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Film id= " + id + ", title= " + title + ", description= " + description + ", releaseYear= "
				+ releaseYear + ", languageId= " + languageId + ", duration= " + duration + ", rentRate= " + rentRate
				+ ", length= " + length + ", replaceCost= " + replaceCost + ", rating= " + rating
				+ ", specialFeatures= " + specialFeatures + ", language= " + language;
	}

//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(description, duration, id, language, languageId, length, rating, releaseYear, rentRate,
				replaceCost, specialFeatures, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && duration == other.duration && id == other.id
				&& Objects.equals(language, other.language) && languageId == other.languageId && length == other.length
				&& rating == other.rating && releaseYear == other.releaseYear
				&& Double.doubleToLongBits(rentRate) == Double.doubleToLongBits(other.rentRate)
				&& Double.doubleToLongBits(replaceCost) == Double.doubleToLongBits(other.replaceCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}

// GETTERS AND SETTERS

	public int getId() {
		return id;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getRentRate() {
		return rentRate;
	}

	public void setRentRate(double rentRate) {
		this.rentRate = rentRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplaceCost() {
		return replaceCost;
	}

	public void setReplaceCost(double replaceCost) {
		this.replaceCost = replaceCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
