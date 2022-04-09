import java.util.Scanner;
public class Player {
    private char playerSymbol;
    private String username;
    private boolean isAllowedToPlay;
    private int selectedLine;
    private int selectedColumn;
    private boolean isLineValid;
    private boolean isColumnValid;

    private Scanner scan = new Scanner(System.in);
    
    
    /*
    The following code contains all important methods that are needed for the game to work.
    */


    public void selectLine(){
        while (isLineValid == false) {
            System.out.println("Please enter a line in which you'd like to set your symbol:");
            int selection = scan.nextInt();

            if (selection < 4) {
                selectedLine = selection;
                isLineValid = true;

            } else {
                System.out.println("You can not select a non existent line. Please choose between 1 - 3.");

            }
        }
    }

    public void selectColumn() {
        while (isColumnValid == false) {
            System.out.println("Please enter a column in which you'd like to set your symbol.");
            int selection = scan.nextInt();

            if (selection < 4) {
                selectedColumn = selection;
                isColumnValid = true;

            } else {
                System.out.println("You can not select a non existent column. Please choose between 1 - 3.");

            }
        }
    }
    
    
    /*
    The following code contains the getter-/setter methods for the Player class.
    */



    public void setPlayerSymbol(){
        System.out.println(username + " please enter the symbol you want to use to play:");
        playerSymbol = scan.next().charAt(0);

    }
    
    public char getPlayerSymbol(){
        return playerSymbol;
        
    }

    public void setUsername(){
        System.out.println("Please enter a username for Player1 and Player2:");
        username = scan.next();

    }

    public String getUsername(){
        return username;

    }

    public void setAllowedToPlay(boolean status){
        isAllowedToPlay = status;

    }

    public boolean getAllowedToPlay(){
        return isAllowedToPlay;

    }

    public int getSelectedLine(){
        return selectedLine;

    }

    public int getSelectedColumn(){
        return selectedColumn;

    }
}
