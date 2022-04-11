public class MatchField {
    private final int XSIZE = 3;
    private final int YSIZE = 3;
    private boolean isFieldBlocked = false;
    private boolean isTie;
    private boolean isWinnerAvailable;
    private boolean isGameOver;

    private char [][] matchField = new char[XSIZE][YSIZE];

    /*
    The following code contains important methods that are used for the game.
    */

    //The method runs through the matchField array and sets all values to ' ' (clearing the field).
    public void initializeMatchField(){
        for (int i = 0; i < XSIZE; i++){
            for (int e = 0; e < YSIZE; e++){
                matchField[i][e] = ' ';
            }
        }
    }

    //The method runs through the matchField array and displays a 3x3 grid (including the updated values)
    public void displayMatchField(){
        for (int i = 0; i < XSIZE; i++){
            for (int e = 0; e < YSIZE; e++){
                System.out.print("[" + matchField[i][e] + "]");
                if (e == YSIZE-1){
                    System.out.println();
                }
            }
        }
    }

    //The method checks if the selected field is already blocked.
    public void checkFieldBlocked(int xcord, int ycord){
        if (matchField[xcord-1][ycord-1] == ' '){
            isFieldBlocked = false;
        } else {
            isFieldBlocked = true;
        }
    }

    //The method prints the input into the selected field of the match field
    public void fillField(int xcord, int ycord, char symbol){
       matchField[xcord-1][ycord-1] = symbol;
    }


    //The method runs through all fields and checks if they've all been used = tie.
    public void checkForTie(){
        boolean tieGame = true;
        for (int i = 0; i < XSIZE; i++){
            for (int e = 0; e < YSIZE; e++){
                if (matchField[i][e] == ' ') {
                    tieGame = false;
                }
            }
        }
        if (tieGame){
            isTie = true;
        } else {
            isTie = false;
        }
    }

    public void checkForWinner(){
        for (int i = 0; i < XSIZE; i++){
            if ((matchField[i][0] == matchField[i][1]) && (matchField[i][0] == matchField[i][2]) && (matchField[i][0] != ' ')){
                isWinnerAvailable = true;
                System.out.println("The game has ended.");
            } else if((matchField[0][i] == matchField[1][i]) && (matchField[i][0] == matchField[2][i]) && (matchField[0][i] != ' ')){
                isWinnerAvailable = true;
                System.out.println("The game has ended.");
            } else if((matchField[0][0] == matchField[1][1]) && (matchField[0][0] == matchField[2][2]) && (matchField[0][0] != ' ')){
                isWinnerAvailable = true;
                System.out.println("The game has ended.");
            } else if((matchField[1][2] == matchField[1][1]) && (matchField[1][2] == matchField[2][1]) && (matchField[1][2] != ' ')){
                isWinnerAvailable = true;
                System.out.println("The game has ended.");
            } else {
                isWinnerAvailable = false;
            }
        }
    }


    /*
    The following code contains getters and setters for the given variables
    */

    public void setGameOver(boolean status){
        isGameOver = status;
    }

    public boolean getGameOver(){
        return isGameOver;
    }

    public boolean getFieldBlocked(){
        return isFieldBlocked;
    }

    public boolean getTie(){
        return isTie;
    }

    public boolean getWinnerAvailable(){
        return isWinnerAvailable;
    }
}
