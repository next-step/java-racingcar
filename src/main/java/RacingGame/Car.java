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
        Random random = new Random(10);
        int randomValue = random.nextInt();
        if (randomValue >= 4){
            return true;
        }
        return false;
    }

}
