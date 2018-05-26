import java.awt.*;
import javax.swing.*;

public class ViewClass extends JPanel {

    int margin = 25;
    int square = 50;
    public Graphics g;
    public String [][] arr = new String[4][4];
       
    public void drawAllSquares(Graphics g){
        drawAndFill( 1, 1, g);
        drawAndFill( 1, 2, g);
        drawAndFill( 1, 3, g);
        drawAndFill( 1, 4, g);
        drawAndFill( 2, 1, g);
        drawAndFill( 2, 2, g);
        drawAndFill( 2, 3, g);
        drawAndFill( 2, 4, g);
        drawAndFill( 3, 1, g);
        drawAndFill( 3, 2, g);
        drawAndFill( 3, 3, g);
        drawAndFill( 3, 4, g);
        drawAndFill( 4, 1, g);
        drawAndFill( 4, 2, g);
        drawAndFill( 4, 3, g);
        drawAndFill( 4, 4, g);
    }

    public void drawAndFill(int X,int Y, Graphics g){

        int startX = margin + (X-1)*square;
        int startY = margin + (Y-1)*square;

        g.setColor(Color.WHITE);
        g.fillRect(startX, startY, square, square);

        g.setColor(Color.BLACK);
        g.drawRect(startX, startY, square, square);
    }
    public void drawStrings(Graphics g){
        g.setColor(Color.BLACK);
        g.drawString("1", square*1, margin/2);
        g.drawString("2", square*2, margin/2);
        g.drawString("3", square*3, margin/2);
        g.drawString("4", square*4, margin/2);
        g.drawString("1", margin/2, square*1);
        g.drawString("2", margin/2, square*2);
        g.drawString("3", margin/2, square*3);
        g.drawString("4", margin/2, square*4);
    }

    public void openCard (){
        for(int i = 0 ; i < arr.length;i++) {
            for(int j=0; j<arr[i].length;j++) {
                g.setColor(Color.black);
                g.drawString(arr[i][j], square * (j+1), square * (i+1));
            }
        }
        this.repaint();
    }
   
    public void paintComponent(Graphics g1){
        this.g=g1;
        super.paintComponent(g);
        drawStrings(g);
        drawAllSquares(g);
        openCard();
          }
    }