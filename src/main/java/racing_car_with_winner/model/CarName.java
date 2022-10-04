package racing_car_with_winner.model;

import racing_car_with_winner.exception.InvalidInputException;

public class CarName {
    private String value;

    public CarName(String value) {
        if (value == null || value.isBlank()) {
            throw new InvalidInputException("자동차의 이름은 공백을 가질 수 없습니다");
        }

        if (value.length() > 5) {
            throw new InvalidInputException("자동차의 이름은 5자를 초과할 수 없습니다");
        }

        this.value = value;
    }
}
