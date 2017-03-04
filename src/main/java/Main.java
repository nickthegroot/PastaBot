import Commands.HelpCommand;
import Commands.PastaCommand;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.Discord4JHandler;
import net.dean.jraw.http.oauth.OAuthException;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import utils.Discord;
import utils.InterfaceListener;
import utils.Keys;

public class Main {

    public static void main(String[] args) throws OAuthException {
        IDiscordClient client = Discord.createClient(Keys.DiscordBotToken, true);
        EventDispatcher dispatcher = client.getDispatcher(); // Gets the EventDispatcher instance for this client instance
        dispatcher.registerListener(new InterfaceListener()); // Registers the IListener example class from above
        CommandHandler handler = new Discord4JHandler(client);
        handler.setDefaultPrefix("~");
        PastaCommand.main(null);
        handler.registerCommand(new PastaCommand());
        handler.registerCommand(new HelpCommand(handler));
    }
}
