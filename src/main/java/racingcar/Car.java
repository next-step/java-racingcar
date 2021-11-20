package racingcar;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void run(RandomNumber randomNumber) {
        if (randomNumber.isMovable()) {
            this.position += 1;
        }
    }

    public void printCurrentPosition() {
        StringBuilder currentPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            currentPosition.append('-');
        }

        System.out.println(currentPosition.toString());
    }
}
