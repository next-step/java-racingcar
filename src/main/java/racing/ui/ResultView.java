package racing.ui;

import java.util.HashMap;
import racing.service.RacingCarService;

public class ResultView {


    private static final String RACING_RESULT_MESSAGE = "실행결과";

    public void result(int racingRound, int racingCar){
        System.out.println(RACING_RESULT_MESSAGE);

        HashMap<Integer, StringBuffer> racingList = RacingCarService.initialRacingCar(racingCar);

        for (int i = 0; i < racingRound; i++) {
            RacingCarService.race(racingList);
        }
    }

}
