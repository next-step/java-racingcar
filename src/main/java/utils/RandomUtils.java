package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int random(int closedStart, int closedEnd) {
        if (closedStart > closedEnd) {
            throw new IllegalArgumentException("시작값이 끝값보다 클 수 없습니다.");
        }

        return ThreadLocalRandom.current()
            .nextInt(closedStart, closedEnd + 1);
    }

}
