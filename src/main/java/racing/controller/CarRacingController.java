package racing.controller;

import racing.entity.Car;
<<<<<<< HEAD
<<<<<<< HEAD
import racing.service.Cars;
=======
import racing.service.CarRacingService;
>>>>>>> 6186238e5 (feat: 테스트 작성)
=======
import racing.service.Cars;
>>>>>>> 090df7a39 (fix: 테스트 수정)
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class CarRacingController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Car> cars = inputView.inputCar();
        int rounds = inputView.inputNumber();

<<<<<<< HEAD
<<<<<<< HEAD
        Cars racingService = new Cars(cars);
=======
        CarRacingService racingService = new CarRacingService(cars);
>>>>>>> 6186238e5 (feat: 테스트 작성)
=======
        Cars racingService = new Cars(cars);
>>>>>>> 090df7a39 (fix: 테스트 수정)
        ResultView resultView = new ResultView();

        for (int i = 0; i < rounds; i++) {
            racingService.moveCars();
            resultView.printResult(racingService.getCars());
        }
        resultView.findWinners(racingService.findWinners());
    }
}

<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 6186238e5 (feat: 테스트 작성)
=======

>>>>>>> 090df7a39 (fix: 테스트 수정)
