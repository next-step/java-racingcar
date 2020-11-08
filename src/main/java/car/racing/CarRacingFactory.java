package car.racing;

public class CarRacingFactory {

    private static final String DELIMITER = ",";

    static CarRacingViewController newInstance(String names) {
        return new CarRacingViewController(
                new ResultView(),
                new CarRacingManager(names.split(DELIMITER), new CarForwardable()));
    }
}
