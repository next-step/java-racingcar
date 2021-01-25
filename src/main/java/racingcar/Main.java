package racingcar;

import racingcar.domain.CarDomain;
import racingcar.domain.RacingDomain;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 입력 : 차 이름, 레이싱 이동 횟수
        String carNames = InputView.inputCarsName();
        int stages = InputView.inputStages();

        // 레이싱 게임 진행
        ArrayList<CarDomain> carDomains = CarDomain.asCarsList(carNames);
        RacingDomain racingDomain = new RacingDomain(carDomains, stages);

        while(!racingDomain.isEnd()) {
            racingDomain.moveCars(); // 1회의 레이싱 상태 갱신
            ResultView.printCurrentCarsState(racingDomain.getCarsList());
        }
        // 진행 결과 output
        ResultView.printWinners(racingDomain.getCarsList(), racingDomain.getMaxDistance());
    }
}