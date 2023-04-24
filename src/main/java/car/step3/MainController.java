package car.step3;

import car.step3.domain.Car;
import car.step3.service.CarService;
import car.step3.view.InputView;
import car.step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        CarService carService = new CarService();
        ResultView resultView = new ResultView();
        //자동차 대수
        String carNames = inputView.scannerCarCertain();
        List<Car> cars = carService.makeCar(carNames);
        //시도할 횟수
        int number = inputView.scannerCarNumber();
        // 시도할 횟수만큼 시도한다. 랜덤 값이 4 이상이면 전진한다.
        System.out.println("실행 결과");
        for (int i = 0; i < number; i++) {
            cars = carService.iteratorCar(cars);
            resultView.result(cars);
        }
        resultView.winnerResult(cars);
    }
}
