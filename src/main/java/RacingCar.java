import domain.Cars;
import view.InputView;
import view.ResultView;

public class RacingCar {

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        int carCount = InputView.getCarCount();
        int tryCount = InputView.getTryCount();

        Cars cars = CarManager.initCars(carCount);
        ResultView.print(cars, tryCount);
    }
}
