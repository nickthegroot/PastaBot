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
    public static String onPastaCommand(String[] args) {
        Listing<Submission> copypasta;
        try {
            RedditClient redditClient = Reddit.getRedditClient();
            if (!redditClient.isAuthenticated()) {
                Reddit.authReddit();
            }
            FluentRedditClient fluent = new FluentRedditClient(redditClient);
            copypasta = fluent.subreddit("copypasta").fetch();
        }   catch (NetworkException | OAuthException e) {
            System.out.println("Network Error Serving Pasta");
            return "An error occurred, please try again later.";
        }

        System.out.println("Serving some pasta.");
        Random random = new Random();
        return StringUtils.abbreviate(copypasta.get(random.nextInt(copypasta.size())).getSelftext(), 2000);
    }
}
