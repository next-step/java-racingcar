package racing.controller;

import racing.entity.Car;
<<<<<<< HEAD
import racing.service.Cars;
=======
import racing.service.CarRacingService;
>>>>>>> 6186238e5 (feat: 테스트 작성)
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class CarRacingController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Car> cars = inputView.inputCar();
        int rounds = inputView.inputNumber();

<<<<<<< HEAD
        Cars racingService = new Cars(cars);
=======
        CarRacingService racingService = new CarRacingService(cars);
>>>>>>> 6186238e5 (feat: 테스트 작성)
        ResultView resultView = new ResultView();

        for (int i = 0; i < rounds; i++) {
            racingService.moveCars();
            resultView.printResult(racingService.getCars());
        }
    }
}

<<<<<<< HEAD

=======
>>>>>>> 6186238e5 (feat: 테스트 작성)
