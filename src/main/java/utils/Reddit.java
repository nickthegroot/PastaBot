package utils;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthException;

public class Reddit {

    private static RedditClient redditClient = new RedditClient(UserAgent.of("desktop", "com.nbdeg.pastabot", "v0.1", "DiscordPastaBot"));

    public static RedditClient authReddit() throws OAuthException {
        System.out.println("Reauthenticating Reddit");
        Credentials credentials = Credentials.script("DiscordPastaBot", Keys.RedditPass, Keys.RedditID, Keys.RedditSecret);
        redditClient.authenticate(redditClient.getOAuthHelper().easyAuth(credentials));
        return redditClient;
    }

    public static RedditClient getRedditClient() {
        return redditClient;
    }
}
