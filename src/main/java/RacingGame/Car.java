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

    public void applyRule(int location) {
        this.location = location;
    }
}
