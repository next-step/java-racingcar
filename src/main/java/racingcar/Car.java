package racingcar;

public class Car {
    private static int STANDARD_TO_GO = 4;
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

    public boolean canGo() {
        int randomNumber = RandomNumberGenerator.randomNumber();
        return randomNumber >= STANDARD_TO_GO;
    }
}
