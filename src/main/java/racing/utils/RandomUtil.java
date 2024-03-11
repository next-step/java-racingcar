package racing.utils;
import racing.Constant;
import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    public static int generateRandomNumber() {
        // 0부터 9까지의 숫자 중 랜덤하게 반환
        return random.nextInt(Constant.RANDOM_NUMBER_RANGE_MAX);
    }

}
