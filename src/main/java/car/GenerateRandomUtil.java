package car;

import java.util.Random;

public class GenerateRandomUtil implements RandomUtil {


    private final int SPEED_MAX = 10;
    Random ran = new Random();

    @Override
    public int random() {
        return ran.nextInt(SPEED_MAX);
    }


}
