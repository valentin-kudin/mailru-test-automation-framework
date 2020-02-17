package core.util.regex;

public class StringOperationsApiVk extends StringOperations {

    private final String POST_ID_REGEX = "(?<=\"id\":).+?(?=,\")";
    private final String WALL_POST_MESSAGE_TEXT = "(?<=text\":\").+?(?=\")";

    public String getPostIdFromString(String text) {
        return getSubstringFromString(text, POST_ID_REGEX);
    }

    public String getWallPostText(String text) {
        return getSubstringFromString(text, WALL_POST_MESSAGE_TEXT);
    }

}
