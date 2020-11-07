package car.racing;

public class ViewControllerFactory {

    static CarRacingViewController newInstance() {
        return new CarRacingViewController(
                new ResultView(),
                new CarRacingManager(new CarForwardableImpl()));
    }
}
