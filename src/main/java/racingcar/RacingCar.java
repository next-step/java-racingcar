package racingcar;

public class RacingCar {
    private int carPosition;

    public RacingCar() {
        this.carPosition = 0;
    }

    public void action(int value) {
        if (value >= 4) {
            this.move();
            return;
        }
        this.holdPosition();
    }

    public void move() {
        this.carPosition++;
        this.printCarPosition();
    }

    public void holdPosition() {
        this.printCarPosition();
    }

    public void printCarPosition() {
        for (int i = 0; i < this.getCarPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getCarPosition() {
        return this.carPosition;
    }
}