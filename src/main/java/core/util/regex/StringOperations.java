package core.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StringOperations {

    public String getSubstringFromString(String text, String regex) {
        String substring = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            substring = matcher.group();
        }
        return substring;
    }
}
