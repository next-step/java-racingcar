package racinggame.dto;

import racinggame.domain.Car;

public class RacingDTO {
    private static final String FORWARD_SIGN = "-";
    private static final String CAR_COLON = " : ";

    private final Car car;

    public RacingDTO(final Car car) {
        this.car = car;
    }

    public String carStatus() {
        return car.getName() + CAR_COLON + carLocation();
    }

    private String carLocation() {
        StringBuilder result = new StringBuilder();
        int location = car.getLocation();
        for (int i = 0; i < location; i++) {
            result.append(FORWARD_SIGN);
        }
        return result.toString();
    }
}
