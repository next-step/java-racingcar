package racingCar;

import racingCar.domain.Car;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.play();
    }

    public void play(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 자동차 갯수, 경주 횟수 입력받기
        int numberOfCars = inputView.askHowMayCars();
        int numberOfTimes = inputView.askHowManyTimes();

        List<Car> cars = new ArrayList<>();

        // 자동차 생성
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        outputView.printRacingResultTitle();

        //자동차 경주 및 결과 출력
        for (int j = 0; j < numberOfTimes; j++) {
            cars.forEach(Car::run);
            outputView.showRacingResult(cars);
        }
    }
}
