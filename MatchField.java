public class MatchField {
    private final int XSIZE = 3;
    private final int YSIZE = 3;
    private boolean isMatchFieldFull;
    private boolean isFieldFull;
    private boolean isGameOver;

    //Builds two dimensional array
    private char[][] matchField = new char [XSIZE][YSIZE];

    /*
    The following method displays the match field within the terminal.
    */

    public void displayMatchField(){
        for (int line = 0; line < XSIZE; line++){
            for (int column = 0; column < YSIZE; column++){
                System.out.print("[" + matchField[line][column] + "]");

                //Prints a new line once the third box is printed.
                if (column == YSIZE-1){
                    System.out.println();
                }
            }
        }
    }

    /*
    The following method initializes the match field and empties all fields.
    */

    public void initializeMatchField(){
        for (int line = 0; line < XSIZE; line++){
            for (int column = 0; column < YSIZE; column++){
                matchField[line][column] = ' ';

            }
        }
    }


    /*
    The following method fills a selected field.
    */

    public void fillField(int xcord, int ycord, char symbol){
        matchField[xcord-1][ycord-1] = symbol;

    }

    public void setMatchFieldFull(){

    }

    public boolean getMatchFieldFull(){
        return isMatchFieldFull;

    }

    public void checkFieldFull(int xcord, int ycord){
        if (matchField[xcord][ycord] == ' '){
            isFieldFull = false;

        } else {
            isFieldFull = true;

        }
    }

    public boolean getFieldFull(){
        return isFieldFull;

    }

    public void setGameOver(){


    }

    public void setGameOverManually(boolean status){
        isGameOver = status;

    }

    public boolean getGameOver(){
        return isGameOver;

    }
}
