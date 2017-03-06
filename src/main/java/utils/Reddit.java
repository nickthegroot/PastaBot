package utils;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;

public class Reddit {

    private static RedditClient redditClient = new RedditClient(UserAgent.of("desktop", "com.nbdeg.pastabot", "v0.1", "DiscordPastaBot"));

    public static void authReddit() throws OAuthException {
        Credentials credentials = Credentials.script("DiscordPastaBot", Keys.RedditPass, Keys.RedditID, Keys.RedditSecret);
        redditClient.authenticate(redditClient.getOAuthHelper().easyAuth(credentials));
    }

    public static RedditClient getRedditClient() {
        return redditClient;
    }
}
