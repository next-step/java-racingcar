package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final CarEngine carEngine;

    public RacingCarGame(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    // view 테스트용
    public static void main(String[] args) {
        CarEngine carEngine = new RandomEngine();
        RacingCarGame racingcar = new RacingCarGame(carEngine);

        InputView inputView = new InputView();
        inputView.receiveAndViewAndValidate();

        racingcar.execute(inputView.getCarCount(), inputView.getRound());
    }

    public void execute(int carCount, int round) {
        Cars cars = new Cars(createCars(carCount));

        race(cars, round);
    }

    private List<Car> createCars(int car) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < car; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    private void race(Cars cars, int round) {
        PrintView printView = new PrintView();

        printView.print("실행 결과");
        for (int i = 0; i < round; i++) {
            cars.moveAll(carEngine);
            printView.result(cars);
        }
    }

}
