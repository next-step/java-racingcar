package car.racing;

public class CarRacingControllerFactory {

    static CarRacingViewController newInstance() {
        return new CarRacingViewController(
                new ResultView(),
                new CarRacingManager());
    }
}
