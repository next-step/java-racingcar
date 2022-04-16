package racingcar;

public class Car implements Comparable<Car> {
    private static final int MOVE_CONDITION = 4;
    private static final int RANGE_START_RANDOM_NUMBER = 0;
    private static final int RANGE_END_RANDOM_NUMBER = 9;
    private static final String CAR_NAME_COLON = " : ";
    private final CarName carName;
    private final Position position;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public Car(String carName, int position) {
        this.carName = new CarName(carName);
        this.position = new Position(position);
    }

    public Car(Car car) {
        this.carName = new CarName(car.carName);
        this.position = new Position(car.position);
    }

    public void move(int generateCondition) {
        if (!validateCondition(generateCondition)) {
            throw new IllegalArgumentException("경주 환경에 문제가 생겼습니다. 관리자에게 문의 해 주세요.");
        }

        if (isMove(generateCondition)) {
            this.position.add();
        }
    }

    private boolean validateCondition(int generateCondition) {
        return generateCondition >= RANGE_START_RANDOM_NUMBER
                && generateCondition <= RANGE_END_RANDOM_NUMBER;
    }

    private boolean isMove(int generateCondition) {
        return generateCondition >= MOVE_CONDITION;
    }

    public boolean isEqualPosition(Car car) {
        return position.isEqualPosition(car.position);
    }

    public String carName() {
        return carName.toString();
    }

    @Override
    public String toString() {
        return carName.toString() + CAR_NAME_COLON + position.toString();
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.position);
    }

}
