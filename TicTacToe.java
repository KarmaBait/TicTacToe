import java.util.Scanner;
public class TicTacToe {
    private static Scanner scan = new Scanner(System.in);
    private static GameConsole console = new GameConsole();
    private static MatchField matchField = new MatchField();
    private static Player playerOne = new Player();
    private static Player playerTwo = new Player();

    public static void main(String[] args) {


         /*
         The following code contains the actual game process
         E.g.: Console outputs, methods etc.
         */

        console.onEnable();

        //Asks both users for their usernames & sets them.
        playerOne.setUsername();
        console.print("Player1: " + playerOne.getUsername());
        playerTwo.setUsername();
        console.print("Player2: " + playerTwo.getUsername());

        //Asks both users for their preferred symbol.
        playerOne.setPlayerSymbol();
        console.print(playerOne.getUsername() + " chose " + playerOne.getPlayerSymbol());
        playerTwo.setPlayerSymbol();
        console.print(playerTwo.getUsername() + " chose " + playerTwo.getPlayerSymbol());

        //Asks both users about who should start the game.
        decideWhoStarts();

        //Initializes and displays the empty match field.
        matchField.initializeMatchField();
        matchField.displayMatchField();

        //While game is not over the game will do this:
        matchField.setGameOverManually(false);
        while (matchField.getGameOver() != true){
            //If player one is allowed to play (if it's their turn) the game will do this:
            if (playerOne.getAllowedToPlay() == true){
                playerOne.selectLine();
                playerOne.selectColumn();
                matchField.checkFieldFull(playerOne.getSelectedLine(), playerOne.getSelectedColumn());

                while (matchField.getFieldFull() != false) {

                    if (matchField.getFieldFull() == true) {
                        console.print(playerOne.getUsername() + ", the field you are trying to use is already blocked.\n" +
                                                                " please select a different field.");

                    } else {
                        matchField.fillField(playerOne.getSelectedLine(), playerOne.getSelectedColumn(), playerOne.getPlayerSymbol());
                        matchField.displayMatchField();

                        playerOne.setAllowedToPlay(false);
                        playerTwo.setAllowedToPlay(true);

                    }
                }
            } else {
                playerTwo.selectLine();
                playerTwo.selectColumn();
                matchField.checkFieldFull(playerTwo.getSelectedLine(), playerTwo.getSelectedColumn());

                while (matchField.getFieldFull() != false) {

                    if (matchField.getFieldFull() == true) {
                        console.print(playerTwo.getUsername() + ", the field you are trying to use is already blocked.\n" +
                                " please select a different field.");

                    } else {
                        matchField.fillField(playerTwo.getSelectedLine(), playerTwo.getSelectedColumn(), playerTwo.getPlayerSymbol());
                        matchField.displayMatchField();

                        playerOne.setAllowedToPlay(true);
                        playerTwo.setAllowedToPlay(false);

                    }
                }
            }
        }
        console.onDisable();

    }

    /*
    The following method makes the users pick the game starting player.
    */

    public static void decideWhoStarts() {
        boolean isValid = false;

        while (isValid != true)  {

            System.out.println("Please decide on who should start the game.");
            System.out.println("Enter '1' if you want " + playerOne.getUsername() + " to start the game.");
            System.out.println("Enter '2' if you want " + playerTwo.getUsername() + " to start the game.");

            int whoStarts = scan.nextInt();

            //If the users enter '1' as game starter, player1 will start.
            if (whoStarts == 1) {
                playerOne.setAllowedToPlay(true);
                playerTwo.setAllowedToPlay(false);
                console.print("Player " + playerOne.getUsername() + " starts the game.");
                isValid = true;

            //If the users enter '2' as game starter, player2 will start.
            } else if (whoStarts == 2) {
                playerOne.setAllowedToPlay(false);
                playerTwo.setAllowedToPlay(true);
                console.print("Player " + playerTwo.getUsername() + " starts the game.");
                isValid = true;

            //If an invalid player number is given they'll be asked to enter a valid one.
            } else {
                System.out.println("The given input was invalid. Please select either '1' or '2'.");
                System.out.println();

            }
        }
    }
}
