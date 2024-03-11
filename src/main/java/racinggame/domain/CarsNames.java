package racinggame.domain;

public class CarsNames {

    private static final int MAXIMUM_NAME_SIZE = 5;

    private String[] carNames;

    public CarsNames(String... carsNames) {
        validationCarsNames(carsNames);
        this.carNames = carsNames;
    }

    private void validationCarsNames(String... carsNames) {
        validEmpty(carsNames);
        for (String carName : carsNames) {
            validNameSize(carName);
        }
    }

    private void validEmpty(String... carsNames) {
        if (carsNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다.");
        }
    }

    private void validNameSize(String carName) {
        if (carName.length() > MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다: " + carName.length());
        }
    }

    public int length() {
        return carNames.length;
    }

    public String getName(int index) {
        return carNames[index];
    }
}
