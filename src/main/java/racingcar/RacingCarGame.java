package racingcar;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.play();
    }

    public void play(){

        // 자동차 갯수, 경주 횟수 입력받기
        int numberOfCars = InputView.askHowManyCars();
        int numberOfTimes = InputView.askHowManyTimes();

        List<Car> cars = new ArrayList<>();

        // 자동차 생성
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        OutputView.printRacingResultTitle();

        //자동차 경주 및 결과 출력
        for (int j = 0; j < numberOfTimes; j++) {
            cars.forEach(Car::run);
            OutputView.showRacingResult(cars);
        }
    }
}
