package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class Actor {
	private int actorId;
	private String actorFirstName;
	private String actorLastName;

	public Actor() {

	}

	public Actor(int actorId, String actorFirstName, String actorLastName) {
		super();
		this.actorId = actorId;
		this.actorFirstName = actorFirstName;
		this.actorLastName = actorLastName;
	}

	@Override
	public String toString() {
		return "Actor ID: " + actorId + " First Name: " + actorFirstName + " Last Name: "
				+ actorLastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorFirstName, actorId, actorLastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(actorFirstName, other.actorFirstName) && actorId == other.actorId
				&& Objects.equals(actorLastName, other.actorLastName);
	}

//GETTERS AND SETTERS
	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorFirstName() {
		return actorFirstName;
	}

	public void setActorFirstName(String actorFirstName) {
		this.actorFirstName = actorFirstName;
	}

	public String getActorLastName() {
		return actorLastName;
	}

	public void setActorLastName(String actorLastName) {
		this.actorLastName = actorLastName;
	}

}
