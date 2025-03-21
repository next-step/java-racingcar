package edu.nextstep.camp.carracing.domain;

import edu.nextstep.camp.carracing.view.ResultView;

import java.util.List;

import static edu.nextstep.camp.carracing.view.InputView.getTryCount;
import static edu.nextstep.camp.carracing.view.InputView.inputCarNames;

public class CarRacing {

    private CarRacing() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static void main(String[] args) {
        List<String> carNames = inputCarNames();
        int tryCount = getTryCount();

        Cars cars = Cars.fromNames(carNames);

        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            cars.printCarStatus();
        }
        ResultView.printWinners(cars.getWinners());
    }
}