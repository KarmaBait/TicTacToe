public class GameConsole {

    /*
    Method that prints a successful start message on startup.
    */
    public void onEnable(){
        System.out.println("Game start successful.");
        System.out.println();

    }

    /*
    Method that prints a successful shut down message on shutdown.
    */

    public void onDisable(){
        System.out.println();
        System.out.println("Game shut down successful.");

    }


    /*
    Method to print a message into the terminal.
    */

    public void print(String msg){
        System.out.println(msg);
        System.out.println();
    }
}
