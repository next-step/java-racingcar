package race;

public class RacingCarFactory {
    public static RacingCar create(String carName) {
        return RacingCarFactory.create(carName, 0);
    }

    public static RacingCar create(String carName, int position) {
        return RacingCar.create(carName, position);
    }
}
