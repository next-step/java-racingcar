package racing.domain;

public class CarName {
    private String carName;

    public CarName(String carName) {
        validateForString(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validateForString(String input) {
        if (input.length() > 5 || input.isBlank()) {
            throw new RuntimeException("부적절한 이름입니다.");
        }
    }
}