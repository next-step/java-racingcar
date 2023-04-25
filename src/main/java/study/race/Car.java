package study.race;

public class Car {

    private String carName;
    private int moved = 0;

    public Car() {}

    public Car(String carName) {
        this.carName = carName;
        validateCarName(carName);
    }

    public void move() {
        moved++;
    }

    public String getName() {
        return carName;
    }

    public int getScore() {
        return moved;
    }

    private void validateCarName(String carName) {
        int carNameMaxLength = 5;

        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalStateException("자동차 이름을 입력해주세요.");
        }

        if (carName.length() > carNameMaxLength) {
            throw new IllegalStateException("자동차 이름은 1~5자만 가능합니다.");
        }
    }

}
