package racing.ui;

import java.util.Arrays;
import java.util.List;

import racing.domain.Racing;

public class ResultView {

    private static final String RACING_RESULT_MESSAGE = "실행결과";
    private static final String RACING_SIGN = "-";

    private String[] raceResult;

    public void result(List<Racing> racingResultList, int racingCar){

        System.out.println(RACING_RESULT_MESSAGE);

        raceResult = new String[racingCar];
        Arrays.fill(raceResult, "");

        for (Racing racingResult : racingResultList) {
            getRacingResult(racingResult);
            System.out.println();
        }
    }

    private void getRacingResult(Racing racingResult) {
        int length = racingResult.getResultLength();
        for (int car = 0; car < length; car++) {
            raceResult[car] = checkIsMoved(racingResult, car, raceResult[car]);
            System.out.println(raceResult[car]);
        }
    }

    public String checkIsMoved(Racing racingResult, int car, String raceResultConvert){
        if(racingResult.compareDetailResult(car)){
            raceResultConvert += RACING_SIGN;
        }
        return raceResultConvert;
    }

}
