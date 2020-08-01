package step3.ui;

import step3.AttemptResult;
import step3.dto.CarWentResult;
import step3.RaceResult;

import java.util.List;

import static step3.ui.MessageConstant.*;

public class Announcer {

    private Announcer() {}

    public static void announceRaceResult(RaceResult raceResult) {
        System.out.println(NEW_LINE+RESULT_MESSAGE);
        List<AttemptResult> attemptResults = raceResult.getAttemptResults();
        attemptResults.forEach(attemptResult -> {
            List<CarWentResult> carWentResults = attemptResult.getCarWentResults();
            carWentResults.forEach(carWentResult -> printResult(carWentResult));
            System.out.println(NEW_LINE);
        });
    }

    private static void printResult(CarWentResult carWentResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < carWentResult.getDistance() ; i ++) {
            stringBuilder.append(DISTANCE_INDICATOR);
        }
        System.out.println(stringBuilder.toString());

    }
}
