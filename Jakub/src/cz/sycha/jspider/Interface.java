package cz.sycha.jspider;

import java.util.Scanner;

/**
 * This is an "interface for communicating with user and executing required functions
 *
 * @author Jakub Sycha <jakubsycha@gmail.com>
 * @version 1.0
 */
public class Interface {

    private final Scanner sc = new Scanner(System.in);
    private final Parser ps = new Parser();

    /**
     * Constructor for the Interface class, basically it starts the whole app
     */
    public Interface() {
        System.out.println("/******************\\");
        System.out.println("| jSpider verze 1.0|");
        System.out.println("\\******************/");
        System.out.println("");

        searchPrompt();
    }

    /**
     * Ask for keywords, then do the search and return a numbered list of movies, than call the fetchMovie function.
     */
    private void searchPrompt() {
        System.out.println("Napište název filmu nebo klíčová slova, která chcete vyhledat:");

        String input = sc.next();

        ps.search(input);
        System.out.println("");
        System.out.println("");
        fetchMovie();
    }

    /**
     * Ask for number of the movie you want to display (has to be called AFTER the searchPrompt() function, otherwise,
     * there would be nothing to fetch.
     */
    private void fetchMovie() {
        System.out.println("Který film chcete zobrazit? (číslo)");

        int input = sc.nextInt();

        String URL = ps.searchResults[input].replace("./", "");
        URL = "http://www.fdb.cz/" + URL;

        ps.getMovie(URL);
    }
}
