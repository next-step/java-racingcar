package racing.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonView {
    public static boolean checkPattern(String text) throws RuntimeException {
        Pattern pattern = Pattern.compile("^\\s*(([a-zA-Z]+),)+([a-zA-Z]+)+\\s*$");
        Matcher matcher = pattern.matcher(text);

        if (!matcher.find()) {
            throw new RuntimeException("패턴 불일치");
        }

        return true;
    }

    public static String[] splitText(String text) {
        return text.split(",");
    }

    public static String[] parseCarNames(String text) throws RuntimeException {
        String[] names = new String[0];

        if (checkPattern(text)) {
            names = splitText(text.trim());
        }

        return names;
    }
}
