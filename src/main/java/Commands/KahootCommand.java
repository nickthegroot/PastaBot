package Commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

import java.io.IOException;

public class KahootCommand implements CommandExecutor {

    @Command(aliases = {"kahoot"}, description = "Deploys up to 50 bots to *hack* kahoot", usage = "kahoot [game pin] [bot name] [number of bots < 50]")
    public static String onKahootCommand(String[] args) throws IOException {
        if (args.length == 3) {
            if (isInteger(args[0])) {
                int pin = Integer.parseInt(args[0]);
                if (pin >= 1000000 && pin <= 9999999) {
                    if (isInteger(args[2])) {
                        int numOfBots = Integer.parseInt(args[2]);
                        if (numOfBots > 0 && numOfBots <= 50) {
                            String command = "python3.4 main.py " + args[0] + " " + args[1] + " " + args[2];
                            Process p = Runtime.getRuntime().exec(command);
                            return "Check kahoot!";
                        } else {
                            return "Too many bots! Max of 50 bots.";
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

    public static boolean isInteger(String str) {
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

}
