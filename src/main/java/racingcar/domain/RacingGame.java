package racingcar.domain;

public class RacingGame {
    private Cars cars = new Cars();

    public Cars createCarInformation(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            cars.addCars(carName);
        }
        return cars;
    }
}
