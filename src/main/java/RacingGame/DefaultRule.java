package RacingGame;

import java.util.Random;

public class DefaultRule implements Rule{

    private static final int RANDOM_NUM_SCOPE = 10;
    private static final Random random = new Random(); //반복사용하는 것은 한번만 선언


    public void playRule(Car racingCar){
        if(isForward()){
            int newLocation = racingCar.isAt();
            racingCar.applyRule(++newLocation);
        }
    }

    private boolean isForward() {

        int randomValue = random.nextInt(RANDOM_NUM_SCOPE);
        return randomValue >= 4;

    }
}
