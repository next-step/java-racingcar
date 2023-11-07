package racingcar.controller;

import racingcar.core.RacingCar;
import racingcar.util.RandomNumber;
import racingcar.domain.Car;
import racingcar.ui.RacingInputView;
import racingcar.ui.RacingResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingMain {
    public static void main(String[] args) {
        int carCount = RacingInputView.carCount();
        int tryCount = RacingInputView.raceTimes();

        RacingGame racingGame = new RacingGame(carCount, tryCount);
        while (!racingGame.isEndGame()) {
            racingGame.startRacing();
            RacingResultView.printResult(racingGame.getCars());
        }
//        // 출력
//        RandomNumber randomNumber = new RandomNumber();
//
//        List<Car> cars = new ArrayList<>();
//        for (int i = 0; i < carCnt; i++) {
//            cars.add(new Car(DEFAULT_FORWARD_CNT, randomNumber.getNumber()));
//        }
//        RacingCar racingCar = new RacingCar(tryCount, cars);
//        racingCar.start();
//        RacingResultView racingResultView = new RacingResultView();
//        System.out.println("실행 결과");
//        racingResultView.resultView(cars);
    }
}
