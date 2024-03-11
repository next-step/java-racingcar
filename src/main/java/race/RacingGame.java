package race;

public class RacingGame {

    public String start(int count, int numberOfCars) {
        return new Car().goForward(count);
    }
}
