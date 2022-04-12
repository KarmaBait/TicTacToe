import java.util.Scanner;
public class TicTacToe {
    private static final Scanner scan = new Scanner(System.in);
    private static final GameConsole console = new GameConsole();
    private static final MatchField matchField = new MatchField();
    private static final Player playerOne = new Player();
    private static final Player playerTwo = new Player();
    public static void main(String[] args) {

        /*
        The following code includes all important methods to keep the game running.
        */

        console.onEnable();

        /*
        The following code asks the players to enter a username, symbol and to decide on who starts the game.
        */

        playerOne.setUsername();
        playerTwo.setUsername();

        playerOne.setPlayerSymbol();
        playerTwo.setPlayerSymbol();

        //checks if the same symbol was used twice (=invalid). Only allows two different symbols.
        while (playerOne.getPlayerSymbol() == playerTwo.getPlayerSymbol()) {
            console.print(playerTwo.getUsername() + ", the symbol you were trying to use has already been taken.");
            playerTwo.setPlayerSymbol();
        }
        //Calls the method to pick who starts the game
        pickWhoStarts();

        //Initializes and displays the empty match field.
        matchField.initializeMatchField();
        matchField.displayMatchField();


        //As long as the game isn't over players will be able to play and select fields.
        while (!matchField.getGameOver()) {
            if (playerOne.getAllowedToPlay()) {
                playerOne.selectRow();
                playerOne.selectColumn();
                matchField.checkFieldBlocked(playerOne.getSelectedRow(), playerOne.getSelectedColumn());

                while (matchField.getFieldBlocked()) {
                    console.print(playerOne.getUsername() + ", the field you were trying to use is already blocked.\n" +
                            "please select a different field.");
                    playerOne.selectRow();
                    playerOne.selectColumn();
                    matchField.checkFieldBlocked(playerOne.getSelectedRow(), playerOne.getSelectedColumn());
                }

                if (!matchField.getFieldBlocked()) {
                    matchField.fillField(playerOne.getSelectedRow(), playerOne.getSelectedColumn(), playerOne.getPlayerSymbol());
                    matchField.checkForWinner();
                    matchField.checkForTie();

                    if (matchField.getTie()) {
                        console.print("The game ends with a tie.");
                        console.print("Game shutting down..");
                        console.onDisable();
                        matchField.setGameOver(true);
                    } else {
                        matchField.displayMatchField();
                        console.print("\n" + playerOne.getUsername() + " finished their turn.");
                        console.print("\nIt is now " + playerTwo.getUsername() + "s turn.");
                        playerOne.setAllowedToPlay(false);
                        playerTwo.setAllowedToPlay(true);
                    }
                }
            } else {
                playerTwo.selectRow();
                playerTwo.selectColumn();
                matchField.checkFieldBlocked(playerTwo.getSelectedRow(), playerTwo.getSelectedColumn());

                while (matchField.getFieldBlocked()) {
                    console.print(playerTwo.getUsername() + ", the field you were trying to use is already blocked.\n" +
                            "Please select a different field.");
                    playerTwo.selectRow();
                    playerTwo.selectColumn();
                    matchField.checkFieldBlocked(playerTwo.getSelectedRow(), playerTwo.getSelectedColumn());
                }

                if (!matchField.getFieldBlocked()) {
                    matchField.fillField(playerTwo.getSelectedRow(), playerTwo.getSelectedColumn(), playerTwo.getPlayerSymbol());
                    matchField.checkForWinner();
                    if(matchField.getWinnerAvailable()){
                        matchField.displayMatchField();
                        console.print(playerTwo.getUsername() + " has won the game.");
                        console.print("Game shutting down..");
                        console.onDisable();
                        matchField.setGameOver(true);
                    }

                    matchField.checkForTie();

                    if (matchField.getTie()){
                        console.print("The game ends with a tie.");
                        console.print("Game shutting down..");
                        console.onDisable();
                        matchField.setGameOver(true);
                    } else {
                        matchField.displayMatchField();
                        console.print("\n" + playerTwo.getUsername() + " finished their turn.");
                        console.print("\nIt is now " + playerOne.getUsername() + "s turn.");
                        playerTwo.setAllowedToPlay(false);
                        playerOne.setAllowedToPlay(true);
                    }
                }
            }
        }
    }

    /*
    The following method allows the players to pick who starts. It also makes sure that no invalid input will be accepted.
    */
    public static void pickWhoStarts(){
        boolean isInputValid = false;
        int selection;
        //Asks for input until a valid input has been given.
        while(!isInputValid){
            console.print("Please enter either '1' " + playerOne.getUsername() + " or '2' " + playerTwo.getUsername() +
                          " to decide who starts.");
            selection = scan.nextInt();
            //If input = 1, player 1 will start and is set to true.
            switch(selection){
                case 1:
                    isInputValid = true;
                    console.print(playerOne.getUsername() + " will start the game.\n");
                    playerOne.setAllowedToPlay(true);
                    playerTwo.setAllowedToPlay(false);
                    break;
                //If input = 2, player 2 will start and is set to true.
                case 2:
                    isInputValid = true;
                    console.print(playerTwo.getUsername() + " will start the game.\n");
                    playerOne.setAllowedToPlay(false);
                    playerTwo.setAllowedToPlay(true);
                    break;
                //If input invalid, the user will be sent an error message and they'll be asked to enter a correct input.
                default:
                    console.print("The given input was incorrect. Please enter either '1' or '2'.");
                    break;
            }
        }
    }
}
