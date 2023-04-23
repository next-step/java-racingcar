package racing.domain;

public class Car {

    public static final int MAX_LENGTH = 5;
    public static final int ZERO = 0;
    public static final int DEFAULT_POSITION = 1;
    private int position = DEFAULT_POSITION;
    private final String name;

    public Car(String name) {
        this.name = substringMaxLength(name);
    }

    public Car(String name, int initPosition) {
        this.position = initPosition;
        this.name = substringMaxLength(name);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private String substringMaxLength(String name) {
        if (name.length() > MAX_LENGTH) {
            return name.substring(ZERO, MAX_LENGTH);
        }
        return name;
    }

    public Car race(int randomNumber) {
        if (randomNumber > 3) {
            return new Car(name, position++);
        }
        return new Car(name, position);
    }

    public int max(int maxPosition) {
        return Math.max(position, maxPosition);
    }

    public boolean isWinner(int winnerPosition) {
        return position == winnerPosition;
    }
}
