package RacingGame.Domain;

import java.util.Random;

public class BigNumberStrategy implements RandomNumberStrategy {
    @Override
    public int GenerateRandomNumber() {
        Random random = new Random();
        int ret = random.nextInt(10);
        while (ret < 4){
            ret = random.nextInt(10);
        }
        return ret;
    }
}
