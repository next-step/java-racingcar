package study.step3.move;

import java.util.Random;

public class RandomlyMove implements Move{
    @Override
    public boolean isSuccess() {
        final Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber >= 4;
    }
}
