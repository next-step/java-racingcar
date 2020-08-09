package cc.oakk.racing.util;

import java.util.List;

public class Validator {
    public static void checkList(List<?> list) {
        if (list == null) {
            throw new IllegalArgumentException("Given list is null.");
        }

        if (list.size() <= 0) {
            throw new IllegalArgumentException("Given list's size should be greater than 0.");
        }
    }

    public static void checkGreaterThanZero(int target) {
        if (target <= 0) {
            throw new IllegalArgumentException("Given number should be greater than 0.");
        }
    }
}
