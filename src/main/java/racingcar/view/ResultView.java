package racingcar.view;

import racingcar.service.Racing;
import racingcar.service.RacingCar;
import racingcar.service.RacingCars;

public class ResultView {
    private int maxPosition;

    public ResultView(int maxPosition) {
        this.maxPosition = maxPosition;
    }

    // racing 결과 출력
    public void printByRacingResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    // racing에서 trial 마다 출력
    public void printByRacingTrials(RacingCar[] racingCars, int nowTrial) {
        for(RacingCar racingCar : racingCars) {
            String carMoveDistance = "-".repeat(racingCar.getPosition());   // 자동차별 position 값 만큼 이동거리 표기

            System.out.println(carMoveDistance);
        }

        // 마지막 시도일 때는 출력하지 않는다.
        if(nowTrial+1 != this.maxPosition) { // list의 index는 0부터 시작하기 때문에
            System.out.println();
        }
    }
}
