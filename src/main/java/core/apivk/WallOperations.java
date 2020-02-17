package core.apivk;

import core.configuration.ConfigurationApiVk;
import core.logfourj.LoggerInitializing;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;

public class WallOperations {

    private final Logger log = LoggerInitializing.getLogger(this.getClass());
    private HttpClient client;
    private URIBuilder builder;
    private HttpGet request;
    private HttpResponse response;
    private static final String ACCESS_TOKEN_WALL = ConfigurationApiVk.getAccessToken(AccessTokenScope.WALL);
    private static final String WALL_POST_METHOD = "https://api.vk.com/method/wall.post?";
    private static final String DELETE_WALL_POST_METHOD = "https://api.vk.com/method/wall.delete?";
    private static final String EDIT_WALL_POST_METHOD = "https://api.vk.com/method/wall.edit?";
    private static final String GET_WALL_POST_METHOD = "https://api.vk.com/method/wall.get?";
    private static final String VERSION = ConfigurationApiVk.getVersion();
    private static final String WALL_OWNER_ID = ConfigurationApiVk.getWallOwnerId();

    public WallOperations() {
        client = HttpClientBuilder.create().build();
    }

    public URIBuilder getStandardBuilder(String wallMethod) {
        try {
            builder = new URIBuilder(wallMethod);
            builder.setParameter("access_token", ACCESS_TOKEN_WALL)
                    .setParameter("owner_id", WALL_OWNER_ID)
                    .setParameter("v", VERSION);
        } catch (URISyntaxException exception) {
            log.error(exception);
        }
        return builder;
    }

    public String executeRequest(URIBuilder builder) {
        String responseInfo = "";
        try {
            request = new HttpGet(builder.build());
            response = client.execute(request);
            responseInfo = EntityUtils.toString(response.getEntity());
        } catch (IOException | URISyntaxException exception) {
            log.error(exception);
        }
        return responseInfo;
    }

    public String postMessageOnWall(String message) {
        String responseInfo = executeRequest(getStandardBuilder(WALL_POST_METHOD)
                .setParameter("message", message));
        log.info("Post was created >>> " + responseInfo);
        return responseInfo;
    }

    public String editPostMessage(String postId, String newMessage) {
        String responseInfo = executeRequest(getStandardBuilder(EDIT_WALL_POST_METHOD)
                .setParameter("message", newMessage)
                .setParameter("post_id", postId));
        log.info("Post was edited >>> " + responseInfo);
        return responseInfo;
    }

    public String deletePostFromWall(String postId) {
        String responseInfo = executeRequest(getStandardBuilder(DELETE_WALL_POST_METHOD)
                .setParameter("post_id", postId));
        log.info("Post was deleted >>> " + responseInfo);
        return responseInfo;
    }

    public String getPostsFromWall(String numberOfPosts) {
        return executeRequest(getStandardBuilder(GET_WALL_POST_METHOD)
                .setParameter("count", numberOfPosts));
    }

    public String getPostsFromWall() {
        return executeRequest(getStandardBuilder(GET_WALL_POST_METHOD));
    }
}
