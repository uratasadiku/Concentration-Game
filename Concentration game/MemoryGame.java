import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

/**
 * This class is used to play the game and has 2 methods, 
 * ShowCards() which takes the initialized 2D Array and is used to play the interactive game and 
 * addElement() takes the x and y position and the 2D array and 
 * is used to add the position of cards that have already been matched so as to not let the user enter the same positions again and again.
 */
public class MemoryGame{
        ViewClass pamja;
        public MemoryGame(ViewClass view){
            pamja=view;
        }

    public void showCards(String[][] initializedArray){
        // display matrix to the players
        String arrayGame[][]={ {"","","",""},
                               {"","","",""},
                               {"","","",""},
                               {"","","",""} };
                               
        pamja.arr = arrayGame;
        String card1;
        int x1 = 0,y1 = 0;
        String card2;
        int x2 = 0,y2 = 0;
        int counter=0;
        // variable to take in if the player want to continue playing
        String cont = "y";
        // maintain the coordinates of cards that are laready opened 16*2 2D matrix will be used
        int[][] openedArray = {{0,0}};
        while(cont.equals("y") || cont.equals("Y"))
        {
            //Display the puzzle to the player
                       
            // Temporary array to display the picked card in the puzzle
            String[][] tempArray = new String[4][4];
            boolean alreadyMatched1 = true;
            // loop to repeat if the entered coordinate is already matched
            while (alreadyMatched1 == true) {
                card1=JOptionPane.showInputDialog("Type the first coordination \n(The number should be splited with , )");
                // split the 2 coordinates
                String[] coordinate1 = card1.split(",");
                // make them as integers
                x1 = Integer.parseInt(coordinate1[0]);
                y1 = Integer.parseInt(coordinate1[1]);
                // As the board is 4 * 4 checking if the entered coordinates are valid
                if (x1 > 4 || y1 > 4) {
                    alreadyMatched1 = true;
                    JOptionPane.showMessageDialog(null,"Wrong input.try again.");
                }
                // if they are valid continue
                else {
                    // checking if the selected card is already matched
                    for (int i=0;i < (openedArray.length);i++){
                        if (x1 == openedArray[i][0] && y1 == openedArray[i][1]) {
                            alreadyMatched1 = true;
                            JOptionPane.showMessageDialog(null,"Card already matched. Pick a new card.");
                            break;
                        }
                        else {
                            alreadyMatched1 = false;
                        }
                    }
                    // Generating the temporary array from the actual
                    for(int i=0;i<4;i++) {
                        for(int j=0;j<4;j++) {
                            tempArray[i][j] = arrayGame[i][j];
                        }
                    }
                    // adding the selected card to the temporary display
                    tempArray[x1-1][y1-1] = initializedArray[x1-1][y1-1];
                    // printing the board with the selected card
                    pamja.arr[x1-1][y1-1]=tempArray[x1-1][y1-1];
                }
            }

            boolean alreadyMatched2 = true;
            while (alreadyMatched2){
                //System.out.println("Please enter the row and column of the second Card to pick:");
                card2=JOptionPane.showInputDialog("Type the second coordination \n(The number should be splited with  , )");
                // split the 2 coordinates
                String[] coordinate2 = card2.split(",");
                // make them as integers
                x2 = Integer.parseInt(coordinate2[0]);
                y2 = Integer.parseInt(coordinate2[1]);
                // As the board is 4 * 4 checking if the entered coordinates are valid
                if (x2 > 4 || y2 > 4) {
                    alreadyMatched2 = true;
                    JOptionPane.showMessageDialog(null,"Wrong input. Please try again");
                }
                // if they are valid continue
                else{
                    // checking if the selected card is already matched
                    for (int i=0;i < (openedArray.length);i++){
                        if (x2 == openedArray[i][0] && y2 == openedArray[i][1]) {
                            alreadyMatched2 = true;
                           JOptionPane.showMessageDialog(null,"Card already matched. Pick a new card.");
                            break;
                        }
                        else{
                            alreadyMatched2 = false;
                        }
                    }
                    // adding the selected card to the temporary display
                    tempArray[x2-1][y2-1] = initializedArray[x2-1][y2-1];
                    // printing the board with the selected card
                     pamja.arr[x2-1][y2-1]=tempArray[x2-1][y2-1];
                }
            }
            // checking if the selected cards are same or not
            if (initializedArray[x1-1][y1-1].equals(initializedArray[x2-1][y2-1])){
                // assigning to the board the matched cards and display them permanently
                arrayGame[x1-1][y1-1] = initializedArray[x1-1][y1-1];
                arrayGame[x2-1][y2-1] = initializedArray[x2-1][y2-1];
               JOptionPane.showMessageDialog(null,"Good Flip! Match Found!");
                // maintaining an array to know which are laready matched
                openedArray = addElement(openedArray,x1,y1);
                openedArray = addElement(openedArray,x2,y2);
                // so, after 8 matches the user wins so maintaining this count
                counter++;
            }
            // If its not a match printing the same.
            else{ try {
                    Thread.sleep(1000);
                    JOptionPane.showMessageDialog(null,"Not a match. Try again.");
                    pamja.arr[x2-1][y2-1]="";
                    pamja.arr[x1-1][y1-1]="";
                      }
                catch (InterruptedException e) {
                    e.printStackTrace();
                    }
                 }
            // Once 8 matches are done, the game is finisihed
            if (counter==8)
            {
                // Display the final message that he won the game
                JOptionPane.showMessageDialog(null,"Congratulations!! Game Finished!");
                //exit out of the game once won
                System.exit(0);
            }
            // if the entire puzzle is not done we need to continue the loop.
            else
            {   cont = "";
                while (!(cont.equals("y") || cont.equals("Y") || cont.equals("N") || cont.equals("n"))) {
                    // Asking if the player want to continue
                    cont = JOptionPane.showInputDialog("Do you want to continue the game. Please enter Y or N: ");
                    
                      }
                }
        }
        // if the user quits the game. Diplay this message
        JOptionPane.showMessageDialog(null,"Thank you for playing.");
    }

    // This is used to add the already matched coordinates to an array
    public int[][] addElement(int[][] openedArray, int x, int y) {
        int[][] result = new int[openedArray.length+1][2];
        for (int i =0;i< openedArray.length; i++)
        {
            result[i][0] = openedArray[i][0];
            result[i][1] = openedArray[i][1];
        }
        result[openedArray.length][0] = x;
        result[openedArray.length][1] = y;
        return result;
    }
}