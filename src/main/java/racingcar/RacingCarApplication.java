package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        // 사용자에게 입력값 받기
        int numberOfCars = inputView.askCarCount();
        int numberOfTrials = inputView.askTrialCount();

        // 전체 자동차 객체 만들기
        RacingCars racingCars = new RacingCars(numberOfCars);

//        // 이동 시도 횟수에 따른 racing 진행
        Racing racing = new Racing(racingCars, numberOfTrials);
        racing.startRacing();
//        RacingCars racingResult = racing.getRacing();


    }
}