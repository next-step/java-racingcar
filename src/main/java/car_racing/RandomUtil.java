package car_racing;

public class RandomUtil {

    public static int getRandomNumber(int from, int to) {
        return from + (int) (Math.random() * (to + 1));
    }
}
