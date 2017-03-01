package utils;

import net.dean.jraw.RedditClient;
import net.dean.jraw.fluent.FluentRedditClient;
import net.dean.jraw.fluent.SubredditReference;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;
import net.dean.jraw.http.oauth.OAuthHelper;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import org.apache.commons.lang3.StringUtils;
import utils.Keys;

import java.util.List;
import java.util.Random;

public class Copypasta {
    private static final Keys keys = new Keys();
    private static Random random = new Random();
    private static RedditClient redditClient = new RedditClient(UserAgent.of("desktop", "com.nbdeg.pastabot", "v0.1", "DiscordPastaBot"));
    private static Credentials credentials = Credentials.script("DiscordPastaBot", keys.RedditPass, keys.RedditID, keys.RedditSecret);

    public static String getCopypasta() throws OAuthException {
        if (!redditClient.isAuthenticated()) {
            OAuthData authData = redditClient.getOAuthHelper().easyAuth(credentials);
            redditClient.authenticate(authData);
        }

        FluentRedditClient fluent = new FluentRedditClient(redditClient);

        SubredditReference subreddit = fluent.subreddit("copypasta");
        List<Listing<Submission>> copypastas = subreddit.fetch(10);
        Listing<Submission> copypastaListing = copypastas.get(random.nextInt(copypastas.size()));
        Submission copypasta = copypastaListing.get(1);

        return StringUtils.abbreviate(copypasta.getSelftext(), 2000);
    }
}