package step5.ui;

import step5.collections.AttemptResult;
import step5.collections.RaceResult;
import step5.dto.CarWentResult;

import java.util.List;

import static step5.constants.MessageConstant.*;

public class Announcer {

    private Announcer() {}

    public static void announceResultPerLap(RaceResult raceResult) {
        System.out.println(NEW_LINE+RESULT_MESSAGE);
        List<AttemptResult> attemptResults = raceResult.getAttemptResults();
        attemptResults.forEach(attemptResult -> printAttemptResult(attemptResult));
    }

    public static void announceFinalResult(RaceResult raceResult) {
        System.out.println(raceResult.getFinalWinnerCarNames() + FINAL_WINNER_CALL);
    }

    private static void printAttemptResult(AttemptResult attemptResult) {
        List<CarWentResult> carWentResults = attemptResult.getCarWentResults();
        carWentResults.forEach(carWentResult -> printCarWentResult(carWentResult));
        System.out.println(NEW_LINE);
    }

    private static void printCarWentResult(CarWentResult carWentResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carWentResult.getCarName() + DELIMITER);
        for(int i = 0 ; i < carWentResult.getDistance() ; i ++) {
            stringBuilder.append(DISTANCE_INDICATOR);
        }
        System.out.println(stringBuilder.toString());

    }
}
