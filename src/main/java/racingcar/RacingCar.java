package racingcar;

public class RacingCar {
    private final String carName;
    private int position;

    public RacingCar(String carName) {
        nameCheck(carName);

        this.carName = carName;
        this.position = 0;
    }

    private void nameCheck(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자 이상입니다");
        }
    }

    public void moveOrNot(int number) {
        final int MOVE_NUMBER = 4;
        if (number >= MOVE_NUMBER) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() { return carName; }
}
