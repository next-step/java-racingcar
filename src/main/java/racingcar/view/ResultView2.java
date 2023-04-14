package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.HashMap;

public class ResultView2 {
    private int maxPosition;
    private HashMap<Integer, RacingCar[]> racingResults = new HashMap<>();

    public ResultView2(HashMap<Integer, RacingCar[]> racingResults) {
        this.maxPosition = racingResults.size();
        this.racingResults = racingResults;
    }

    // racing 결과 출력
    public void printRacingResult() {
        System.out.println();
        System.out.println("실행 결과");

        for(int i=0; i<this.racingResults.size(); i++){
            printRacingResultByTrial(this.racingResults.get(i), i);
        }

    }

    // racing에서 trial 마다 출력
    public void printRacingResultByTrial(RacingCar[] racingCars, int nowTrial) {
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
