package racing.ui;

import java.util.Arrays;
import java.util.List;

import racing.domain.Racing;

public class ResultView {

    private static final String RACING_RESULT_MESSAGE = "실행결과";
    private static final String RACING_SIGN = "-";

    private String[] racingResult;

    public void result(List<Racing> racingList, int racingCar){

        System.out.println(RACING_RESULT_MESSAGE);

        racingResult = new String[racingCar];
        Arrays.fill(racingResult, "");

        for (Racing racing : racingList) {
            getRacingResult(racing);
            System.out.println();
        }
    }

    private void getRacingResult(Racing racing) {
        int length = racing.getRacingLength();
        for (int car = 0; car < length; car++) {
            racingResult[car] = checkIsMoved(racing, car, racingResult[car]);
            System.out.println(racingResult[car]);
        }
    }

    public String checkIsMoved(Racing racing, int car, String result){
        if(racing.getRacingResult(car)){
            result += RACING_SIGN;
        }
        return result;
    }

}
