import Commands.HelpCommand;
import Commands.PastaCommand;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.Discord4JHandler;
import net.dean.jraw.http.oauth.OAuthException;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.obj.Status;
import utils.Discord;
import utils.InterfaceListener;
import utils.Keys;

public class Main {

    public static void main(String[] args) throws OAuthException {
        IDiscordClient client = Discord.createClient(Keys.DiscordBotToken, true); // Your client instance. Of course it should be initialized!
        EventDispatcher dispatcher = client.getDispatcher(); // Gets the EventDispatcher instance for this client instance
        dispatcher.registerListener(new InterfaceListener()); // Registers the IListener example class from above
        CommandHandler handler = new Discord4JHandler(client);
        handler.setDefaultPrefix("~");
        PastaCommand.main(null);
        handler.registerCommand(new PastaCommand());
        handler.registerCommand(new HelpCommand(handler));
    }
}
