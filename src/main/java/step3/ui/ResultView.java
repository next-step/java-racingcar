package step3.ui;

import java.util.List;
import step3.domain.CarRacingGameResult;
import step3.domain.CarRunResult;
import step3.domain.Round;

public class ResultView {

    public static final char PROGRESS_SYMBOL = '-';
    private static final String COLON_DELIMITER = " : ";

    private static ResultView instance = new ResultView();


    private ResultView() {
    }

    public static ResultView getInstance() {
        return instance;
    }


    public void printAllRoundResult(CarRacingGameResult result) {
        System.out.println("실행 결과: ");
        List<Round> playedRounds = result.getPlayedRounds();

        for (Round playedRound : playedRounds) {
            printRoundResult(playedRound);
        }
        System.out.println(result.getWinnerNames()+"가 최종 우승했습니다.");
    }

    private void printRoundResult(Round playedRound) {
        List<CarRunResult> carRunResults = playedRound.getCarRunResults();
        for (CarRunResult result : carRunResults) {
            System.out.println(generateCarRunResultString(result));
        }
        System.out.println();
    }

    public String generateCarRunResultString(CarRunResult result) {
        String carName = result.getCarName();
        int runDistance = result.getRunDistance();

        return carName + COLON_DELIMITER + generateProgressString(runDistance);
    }

    private String generateProgressString(int runDistance) {
        String progress = "";
        for (int i = 0; i < runDistance; i++) {
            progress = progress + PROGRESS_SYMBOL;
        }
        return progress;
    }

}
