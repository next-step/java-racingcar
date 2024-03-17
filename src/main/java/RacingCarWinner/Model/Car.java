package RacingCarWinner.Model;

public class Car implements Comparable<Car> {
    private static final String HYPHEN = "-";
    private static final String SPACE = " ";
    private static final String COLON = ":";
    int currentPosition;

    String name;

    public Car(String name) {
        currentPosition = 0;
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }

    public void moveCar(int boosterValue) {
        if (boosterValue >= 4) {
            currentPosition++;
        }
    }

    public String makeStringCurrentPosition() {
        return name + SPACE +COLON + SPACE + HYPHEN.repeat(currentPosition);
    }

    @Override
    public int compareTo(Car other) {
        return other.getCurrentPosition() - this.getCurrentPosition();
    }
}
