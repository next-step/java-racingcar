package step3.service;

import java.util.Random;

/**
 * Created By mand2 on 2020-11-07.
 */
public class Randomize {
    public static int random() {
        return new Random().nextInt(10);
    }
}
