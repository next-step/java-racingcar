package racing.domain;

public class Car {

    public static final int DEFAULT_POSITION = 0;
    private int position = DEFAULT_POSITION;
    private final Name name;

    public Car(String name) {
        this(name,DEFAULT_POSITION);
    }

    public Car(String name, int initPosition) {
        this.position = initPosition;
        this.name = new Name(name);
    }

    public int getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public Car race(int randomNumber) {
        if (randomNumber > 3) {
            return new Car(name.toString(), position++);
        }
        return new Car(name.toString(), position);
    }

    public int max(int maxPosition) {
        return Math.max(position, maxPosition);
    }

    public boolean isWinner(int winnerPosition) {
        return position == winnerPosition;
    }
}
