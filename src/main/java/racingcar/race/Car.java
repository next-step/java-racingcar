package racingcar.race;

public class Car {
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public void move(int number) {
        if (RacingModel.isMovePossible(number)) {
            this.position++;
        }
    }
    public int getPosition() {
        return position;
    }

}
