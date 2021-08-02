package domain;

public class CarName {

    private String carName;

    public CarName(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1이상 5이하여야 합니다.");
        }
        this.carName = carName;
    }

    public String readCarName() {
        return this.carName;
    }

}
