package Commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import net.dean.jraw.RedditClient;
import net.dean.jraw.fluent.FluentRedditClient;
import net.dean.jraw.http.NetworkException;
import net.dean.jraw.http.oauth.OAuthException;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import org.apache.commons.lang3.StringUtils;
import utils.Reddit;

import java.util.Random;

public class PastaCommand implements CommandExecutor {
    @Command(aliases = {"pasta", "copypasta"}, description = "Gets a random copypasta from /r/copypasta.", usage = "pasta")
    public static String onPastaCommand(String[] args) throws OAuthException {
        Listing<Submission> copypasta = null;
        RedditClient redditClient;
        try {
            redditClient = Reddit.getRedditClient();
            if (!redditClient.isAuthenticated()) {
                Reddit.authReddit();
            }
            FluentRedditClient fluent = new FluentRedditClient(redditClient);
            copypasta = fluent.subreddit("copypasta").fetch();
        }   catch (NetworkException | NullPointerException e) {
            Reddit.authReddit();
            onPastaCommand(args);
        }

        System.out.println("Serving some pasta.");
        Random random = new Random();
        if (copypasta != null) {
            if (args.length > 0) {
                return "Too many arguments! Use `~help` to get usages.";
            } else if (args.length == 0) {
                return StringUtils.abbreviate(copypasta.get(random.nextInt(copypasta.size())).getSelftext(), 2000);
            }
        }

        // Something went wrong, display error message
        return "An error occurred, please try again later.";
    }
}
