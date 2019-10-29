package study.firstweek.firststep;

import java.util.List;

public class StringUtils {

    public boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str == "" || str.trim().isEmpty();
    }

    public boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public boolean isEvenInputLength(List<String> str) {
        return str.size() % 2 == 0;
    }
}
