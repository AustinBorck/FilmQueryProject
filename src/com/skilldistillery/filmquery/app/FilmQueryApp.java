package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) throws SQLException {
    FilmQueryApp app = new FilmQueryApp();
//    app.test();
    app.launch();
  }

  private void test() throws SQLException {
    Film film = db.findFilmById(1);
    List<Film> film2 = db.findWithKeyWord("dog");
    System.out.println(film2);
   // Actor actor = db.findActorById(1);
    //List<Actor> actor2 = db.findActorsByFilmId(1);
    System.out.println(film);
    //System.out.println(actor);
    //System.out.println(actor2);
  }

  private void launch() throws SQLException {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) throws SQLException {
	  boolean keepGoing = true;
    while(keepGoing) {
	  System.out.println("--------- Welcome to the Movie Database ---------");
	  System.out.println("Please choose what you would like to do!");
	  System.out.println("1. Search for a movie with its ID number.");
	  System.out.println("2. Search for a movie with a keyword.");
	  System.out.println("3. Exit the database application.");
	  String userChoice = input.nextLine();
	  
	  switch(userChoice) {
	  case "1":
		  System.out.println();
		  System.out.print("Please enter the movies ID number: ");
		  int userIdNum = input.nextInt();
		  System.out.println(db.findFilmById(userIdNum));
		  break;
	  case "2":
		  System.out.println();
		  System.out.print("Please enter the keyword: ");
		  String userKeyword = input.nextLine();
		  System.out.println(db.findWithKeyWord(userKeyword));
		  break;
	  case "3":
		  System.out.println("Thank you for using our application!");
		  keepGoing = false;
		  System.exit(0);
		  break;
	  default: 
		  System.out.println("Error please enter a valid choice.");
	  
	  }
	  
	  
	  
	  
	  }
  }

}
