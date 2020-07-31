package step3;

import java.util.List;

public class Anncouncer {

    private static final String RESULT_MESSAGE = "실행 결과";

    public static void announceRaceResult(RaceResult raceResult) {
        System.out.println("\n"+RESULT_MESSAGE);
        List<AttemptResult> attemptResults = raceResult.getAttemptResults();
        attemptResults.forEach(attemptResult -> {
            List<CarWentResult> carWentResults = attemptResult.getCarWentResults();
            carWentResults.forEach(carWentResult -> printResult(carWentResult));
            System.out.println("\n");
        });
    }

    private static void printResult(CarWentResult carWentResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < carWentResult.getDistance() ; i ++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());

    }
}
