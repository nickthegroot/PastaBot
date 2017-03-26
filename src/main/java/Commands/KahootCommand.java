package Commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

import java.io.IOException;

public class KahootCommand implements CommandExecutor {

   // private KahootHack kahootHackAPI = new KahootHack();
    private static Integer maxBots = 50;
    private static Integer currentBots = 0;

    @Command(aliases = {"kahoot"}, description = "Deploys up to 50 bots to *hack* kahoot", usage = "kahoot [game pin] [bot name] [number of bots]")
    public static String onKahootCommand(String[] args) throws IOException {
        if (args.length == 3) {
            if (isInteger(args[0])) {
                int pin = Integer.parseInt(args[0]);
                //TODO: Might want to check if pin is an actual game here...
                if (pin >= 1000000 && pin <= 9999999) {
                    if (isInteger(args[2])) {


                        int botsToAdd = Integer.parseInt(args[2]);
                        String botName = args[1];

                        if (botsToAdd + currentBots > maxBots) {

                            currentBots = currentBots + botsToAdd;

                            //spawn in the bots here

                            return "Check kahoot!";


                        } else {
                            return "Too many bots! There is a maximum of " + maxBots + " bots running at once. Please wait until a kahoot game has ended or decrease the number of bots you are adding.";
                        }
                    }
                }
            } else {
                return "Invalid Pin!";
            }
        }
        else {
            return "Wrong arguments! Check usage with `~help`";
        }
        return "Something went wrong. Please try again";
    }

    private static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static void removeBot(){
        removeBots(1);
    }

    public static void removeBots(int botsToRemove){
        if (currentBots - botsToRemove >= 0) {

        } else {
            System.out.println("ERROR: Not enough bots to remove!");
        }

    }

}
