package racing.service;

import java.util.List;

public class NameCheck {
    public static boolean nameCheck(List<String> nameList) {
        return nameList.stream().anyMatch(i -> i.length() > 5);
    }
}
