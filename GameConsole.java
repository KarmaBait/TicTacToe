public class GameConsole {

    /*
    The following methods outputs a successful startup message.
    */

    public void onEnable(){
        System.out.println("The game started successfully.");
    }

    /*
    The following method outputs a message (notifications, gameupdates etc.).
    */

    public void print(String msg){
        System.out.println(msg);
    }

    /*
    The following method outputs a successful shut down message.
    */

    public void onDisable(){
        System.out.println("The game shut down successfully.\n");
    }
}
