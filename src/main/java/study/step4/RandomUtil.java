package study.step4;

public class RandomUtil {

    public static int makeRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
