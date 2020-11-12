package step5.domain;

import java.util.Random;

/**
 * Created By mand2 on 2020-11-07.
 */
public class Randomize {

    public Randomize() {}

    public static int random() {
        return new Random().nextInt(10);
    }
}
