import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * This is used to call the actual class and its methods which initializes the game deck and then allows to play the game
 */
public class GameTest {

    public static void main(String[] args) {

        ViewClass v = new ViewClass();
        JFrame u = new JFrame();
        u.setSize(250, 275);
        u.getContentPane().add(v);
        u.setTitle("Concetration Game");
        u.setVisible(true);
        //u.setResizable(false);
        u.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardDeck puzzle = new CardDeck();
        // Initialize the cards to play teyy game from the set provided
        String[][] cardsDisplay = puzzle.initializeCards();
        MemoryGame game = new MemoryGame(v);
        // calling the interactive game
        game.showCards(cardsDisplay);
    }
}