package utils;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;

public class Reddit {
    private static RedditClient redditClient = new RedditClient(UserAgent.of("desktop", "com.nbdeg.pastabot", "v0.1", "DiscordPastaBot"));
    private static Credentials credentials = Credentials.script("DiscordPastaBot", Keys.RedditPass, Keys.RedditID, Keys.RedditSecret);

    public static void authenticateReddit() throws OAuthException {
        OAuthData authData = redditClient.getOAuthHelper().easyAuth(credentials);
        redditClient.authenticate(authData);
    }

    public static RedditClient getRedditClient() {
        return redditClient;
    }
}
