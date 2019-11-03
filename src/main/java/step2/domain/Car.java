package step2.domain;

public class Car {
    public static final int MIN_RANDOM_NUMBER = 4;

    private int position;
    private String name;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public Car move(int random) {
        return new Car(tryMove(random), this.name);
    }

    public int tryMove(int randomNumber) {
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

    public boolean isBiggerThan(int maxPosition) {
        return this.position > maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getWinner(int maxPosition) {
        return this.position == maxPosition ? this.name : "";
    }
}
