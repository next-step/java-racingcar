package racingcar;

public class Car {
    private static final int STANDARD_TO_GO = 4;
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void run() {
        if (canGo()) {
            this.position += 1;
            return;
        }
    }

    private boolean canGo() {
        int randomNumber = RandomNumberGenerator.randomNumber();
        return randomNumber >= STANDARD_TO_GO;
    }

    public void printCurrentPosition() {
        StringBuilder currentPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            currentPosition.append('-');
        }

        System.out.println(currentPosition.toString());
    }
}
