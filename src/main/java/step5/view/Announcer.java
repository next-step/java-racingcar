package step5.view;

import step5.domain.collections.AttemptResult;
import step5.domain.collections.RaceResult;
import step5.dto.CarWentResult;
import step5.view.output.OutputChannel;

import java.util.List;

import static step5.constants.MessageConstant.*;

public class Announcer {

    private final OutputChannel outputChannel;

    public Announcer(OutputChannel outputChannel) {
        this.outputChannel = outputChannel;
    }

    public void announceFinalResult(RaceResult raceResult) {
        announceResultPerLap(raceResult);
        announceWinnersName(raceResult);
    }

    private void announceResultPerLap(RaceResult raceResult) {
        outputChannel.printLine(NEW_LINE+RESULT_MESSAGE);
        List<AttemptResult> attemptResults = raceResult.getAttemptResults();
        attemptResults.forEach(attemptResult -> printAttemptResult(attemptResult));
    }

    private void announceWinnersName(RaceResult raceResult) {
        outputChannel.printLine(raceResult.getFinalWinnerCarNames() + FINAL_WINNER_CALL);
    }

    private void printAttemptResult(AttemptResult attemptResult) {
        List<CarWentResult> carWentResults = attemptResult.getCarWentResults();
        carWentResults.forEach(carWentResult -> printCarWentResult(carWentResult));
        outputChannel.printLine(NEW_LINE);
    }

    private void printCarWentResult(CarWentResult carWentResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carWentResult.getCarName() + DELIMITER);
        for(int i = 0 ; i < carWentResult.getDistance() ; i ++) {
            stringBuilder.append(DISTANCE_INDICATOR);
        }
        outputChannel.printLine(stringBuilder.toString());

    }
}
