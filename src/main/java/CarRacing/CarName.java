package CarRacing;

public class CarName {

    private String carName;

    public CarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과하지 않습니다.");
        }
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비어있으면 안됍니다.");
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }
}
