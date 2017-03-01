import Commands.PastaCommand;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.Discord4JHandler;
import sx.blah.discord.api.IDiscordClient;
import utils.Discord;
import utils.Keys;

public class Main {
    static Discord discord = new Discord();
    static final Keys keys = new Keys();

    public static void main(String[] args) {
        IDiscordClient client = discord.createClient(keys.DiscordBotToken, true); // Your client instance. Of course it should be initialized!
        CommandHandler handler = new Discord4JHandler(client);
        handler.registerCommand(new PastaCommand());
    }
}
