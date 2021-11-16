package racing.model;

/**
 * .
 */
public class CarName {

    private final String carName;

    public CarName(String inputString) {
        this.carName = validCarName(inputString);
    }

    private String validCarName(String inputString) {
        if (inputString.length() <= 5) {
            return inputString;
        }
        throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    public String getCarName() {
        return carName;
    }
}
