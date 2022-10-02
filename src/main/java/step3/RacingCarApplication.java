package step3;

import java.util.List;

public class RacingCarApplication {

    private static final InputView INPUT_VIEW = new InputView();
    private static final Play PLAY = new Play();

    public static void main(String[] args) {
        Cars cars = new Cars();
        List<Car> carList = cars.Cars(INPUT_VIEW.numberOfCar());
        int count = INPUT_VIEW.count();

        PLAY.playGame(carList, count);
    }
}
