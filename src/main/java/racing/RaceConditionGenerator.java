package racing;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RaceConditionGenerator {

    private static final Integer RACE_CONDITION_NUM_LIMIT = 10;
    private static final Integer BASE_VALUE = 4;

    // 0 <= generated value < limit
    public static Integer randPositiveOrZero(int limit) {
        Integer num;
        
        try {
            SecureRandom instanceStrong = SecureRandom.getInstanceStrong();
            num = instanceStrong.nextInt(limit);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("난수 생성에 실패했습니다.");
        }

        return num;
    }

    public static Boolean isGreaterThanEqualToBase(Integer base, Integer value) {
        int result = value.compareTo(base);
        return result >= 0;
    }

    public static Boolean isForwardable() {
        return isGreaterThanEqualToBase(BASE_VALUE, randPositiveOrZero(RACE_CONDITION_NUM_LIMIT));
    }

}
