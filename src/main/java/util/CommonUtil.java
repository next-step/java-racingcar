package util;

import java.util.Random;

public class CommonUtil {
  
    Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(10);
    }
}
