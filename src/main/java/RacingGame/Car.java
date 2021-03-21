package RacingGame;
import java.util.Random;
import java.util.function.Function;

public class Car {

    private int location;

    public Car(){
        this.location = 0;
    }

    public int isAt(){
        return this.location;
    }

    public void stopOrMove(){
        if (isForward()){
            this.location += 1;
        }
    }

    private boolean isForward() {
        Random random = new Random();
        int randomValue = random.nextInt(10);
        if (randomValue >= 4){
            return true;
        }
        return false;
    }

}
