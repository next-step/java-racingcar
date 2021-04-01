package RacingGame;
import java.util.Random;
import java.util.function.Function;

public class Car {

    private int location;
    private static final int RANDOM_NUM_SCOPE = 10;
    private Random random = new Random(); //반복사용하는 것은 한번만 선언해주

    public Car(){
        this.location = 0;
    }

    public int isAt(){
        return this.location;
    }

    //룰에 따라 다르게 적용될 수 있도록 strategy pattern
    public void stopOrMove(){
        if (isForward()){
            this.location += 1;
        }
    }

    private boolean isForward() {

        int randomValue = random.nextInt(RANDOM_NUM_SCOPE);
        return randomValue >= 4;

    }

}
