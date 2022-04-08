package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 사용자 값 입력 및 자동차 리스트 초기화
        int rounds = InputView.promptRounds();
        List<Car> cars = initCars();

        // 진행자 생성
        RacingCarGame host = new RacingCarGame(cars, rounds);

        // 경주 진행
        OutputView.printRaceStart();
        for (int i = 0; i < rounds; i++) {
            host.proceedRound();
            OutputView.printCurrentPosition(cars);
        }
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        int carCount = InputView.promptCarCount();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
