package racingcar;

public class Racingcar {

    int carNumber;
    int carMovePosition = 0;

    public Racingcar(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarMovePosition() {
        return carMovePosition;
    }

    public void setCarMovePosition(int carMovePosition) {
        this.carMovePosition = carMovePosition;
    }
}
