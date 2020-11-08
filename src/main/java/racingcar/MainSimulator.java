package racingcar;

import racingcar.application.RacingSimulator;
import racingcar.domain.Car;
import racingcar.application.CarsGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class MainSimulator {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        CarsGenerator carsGenerator = new CarsGenerator();
        RacingSimulator racingSimulator = new RacingSimulator();

        System.out.println("자동차 대수는 몇 대 인가요?");
        int countOfCar = inputView.insertCount();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int countOfRacing = inputView.insertCount();

        Car[] cars = carsGenerator.generateCars(countOfCar);

        if (cars.length == 0) {
            return;
        }

        System.out.println("실행 결과");

        for (int i = 0; i < countOfRacing; i++) {
            racingSimulator.race(cars);
            resultView.printDistanceOfCar(cars);
            System.out.println("");
        }
    }
}
