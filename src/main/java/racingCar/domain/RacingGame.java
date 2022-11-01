package racingCar.domain;

public class RacingGame {
    public static RacingCars start(RacingCars cars, int numOfRounds) {
        RacingCars result = cars;

        for (int i = 0; i < numOfRounds; i++) {
            result = result.racing();
        }

        return result;
    }
}
