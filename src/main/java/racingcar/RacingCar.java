package racingcar;

public class RacingCar {
    private final String carName;
    private int position;
    private final int MOVE_NUMBER = 4;

    public RacingCar(String carName) {
        CheckName(carName);

        this.carName = carName;
        this.position = 0;
    }

    private void CheckName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자 이상입니다");
        }
    }

    public void moveOrNot(int move) {
        if (move >= MOVE_NUMBER) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() { return carName; }

    public boolean maxPosition(int maxPosition) {
        return this.position == maxPosition;
    }
}
