import java.util.Scanner;
public class Player {
    private String username;
    private char playerSymbol;
    private boolean isAllowedToPlay;
    private int selectedRow;
    private int selectedColumn;

    Scanner scan = new Scanner(System.in);

    /*
    The following code contains important methods to keep the game running.
    */
    //Makes the player select a row which he wants his symbol to be placed at.
    public void selectRow(){
        boolean isInputValid = false;
        int selection;
        //If row is invalid it'll make him input a new one.
        while (!isInputValid){
            System.out.println(username + ", please enter a row that you'd like to place your symbol in.");
            selection = scan.nextInt();

            if ((selection < 4) && (selection > 0)){
                selectedRow = selection;
                isInputValid = true;
            } else {
                System.out.println("You can not select an invalid row. Please choose between 1 - 3.");
            }
        }
    }

    //Makes the player select a column which he wants his symbol to be placed at.
    public void selectColumn(){
        boolean isInputValid = false;
        int selection;
        //If column is invalid it'll make him input a new one.
        while (!isInputValid){
            System.out.println(username + ", please enter a column that you'd like to place your symbol in.");
            selection = scan.nextInt();

            if ((selection < 4) && (selection > 0)){
                selectedColumn = selection;
                isInputValid = true;
            } else {
                System.out.println("You can not select an invalid column. Please choose between 1 - 3.");
            }
        }
    }



    /*
    The following methods are getters and setters for the given variables.
    */

    public void setUsername(){
        System.out.println("\nPlease enter a username then press 'Enter'.");
        username = scan.next();
    }

    public String getUsername(){
        return username;
    }

    public void setPlayerSymbol(){
        System.out.println("\n" + username + ", please select a symbol that you'd like to use.");
        playerSymbol = scan.next().charAt(0);
    }

    public char getPlayerSymbol(){
        return playerSymbol;
    }

    public void setAllowedToPlay(boolean status){
        isAllowedToPlay = status;
    }

    public boolean getAllowedToPlay(){
        return isAllowedToPlay;
    }

    public int getSelectedRow(){
        return selectedRow;
    }

    public int getSelectedColumn(){
        return selectedColumn;
    }
}
