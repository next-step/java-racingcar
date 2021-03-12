package step4;

import java.util.Random;

public class Stop extends Random {
    @Override
    public int nextInt(int number) {
        return 3;
    }
}
