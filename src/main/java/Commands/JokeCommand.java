package Commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import net.dean.jraw.RedditClient;
import net.dean.jraw.fluent.FluentRedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import org.apache.commons.lang3.StringUtils;
import utils.Reddit;

import java.util.Random;

public class JokeCommand implements CommandExecutor {

    @Command(aliases = {"joke", "prank"}, description = "Gets a random joke from /r/jokes.", usage = "joke")
    public static String onPastaCommand(String[] args) throws OAuthException {
        RedditClient redditClient = Reddit.redditClient;
        if (!redditClient.isAuthenticated()) {
            Reddit.authenticateReddit();
        }

        FluentRedditClient fluent = new FluentRedditClient(redditClient);
        Random random = new Random();
        Listing<Submission> jokes = fluent.subreddit("jokes").fetch();
        System.out.println("Telling a bad joke.");
        Submission joke = jokes.get(random.nextInt(jokes.size()));
        return StringUtils.abbreviate(("**" + joke.getTitle() + "**\n" + joke.getSelftext()), 2000);
    }
}
