package step2.domain;

public class Car {
    public static final int MIN_RANDOM_NUMBER = 4;

    private int position;
    private String name;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int random) {
        this.position = tryMove(random);
    }

    private int tryMove(int randomNumber) {
        int movedPosition = this.position;

        movedPosition = moveForward(randomNumber, movedPosition);

        return movedPosition;
    }

    private int moveForward(int number, int position) {
        if (number >= MIN_RANDOM_NUMBER) {
            position = position + 1;
        }

        return position;
    }
}
