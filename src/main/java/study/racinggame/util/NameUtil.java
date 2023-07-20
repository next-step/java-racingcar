package study.racinggame.util;

import java.util.List;

public class NameUtil {
    public static List<String> convertToList(String rawCarNames) {
        return List.of(rawCarNames.split(","));
    }
}
