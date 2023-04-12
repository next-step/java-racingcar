package racingcar;

import racingcar.service.Racing;
import racingcar.service.RacingCar;
import racingcar.service.RacingCars;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        // 사용자에게 입력값 받기
        List<Integer> inputValues = inputView.input();
        int numberOfCars = inputValues.get(0); // 자동차 수
        int numberOfTrials = inputValues.get(1); // 이동 시도 횟수

        // 전체 자동차 객체 만들기
        RacingCars racingCars = new RacingCars(numberOfCars);

        // 이동 시도 횟수에 따른 racing 진행
        Racing racing = new Racing(racingCars, numberOfTrials);
        racing.startRacing();
        RacingCars racingResult = racing.getRacing();

    }
}
