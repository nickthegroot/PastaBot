package Commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import net.dean.jraw.http.oauth.OAuthException;
import utils.Copypasta;

public class PastaCommand implements CommandExecutor {
    Copypasta copypasta = new Copypasta();

    @Command(aliases = {"~pasta", "~copypasta"}, description = "Gets a random copypasta from /r/copypasta.", usage = "~pasta")
    public String onPastaCommand(String[] args) {
        System.out.println("Received Pasta Command");
        try {
            return copypasta.getCopypasta();
        } catch (OAuthException e) {
            e.printStackTrace();
        }
        return "An error occurred, please try again later.";
    }
}