package RacingCar.Model;

public class Car {
    private static final String HYPHEN = "-";
    int currentState;

    public Car() {
        currentState = 0;
    }

    public void moveCar(int boosterValue) {
        if (boosterValue >= 4) {
            currentState++;
        }
    }

    public String makeStringCurrentState() {
        return HYPHEN.repeat(currentState);
    }
}
