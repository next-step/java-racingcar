package RacingCarV2.view;

import RacingCarV2.model.RaceResult;
import RacingCarV2.model.StageResult;

import java.util.List;

public class WinnerView {

    private static final String END_MESSAGE = " 최중 우승하였습니다.";

    private List<StageResult> stageResults;

    public WinnerView(List<StageResult> stageResults) {
        this.stageResults = stageResults;
    }

    void print() {
        RaceResult raceResult = new RaceResult(stageResults);
        List<String> winners = raceResult.getWinners();
        System.out.println(winners.toString() + END_MESSAGE);
    }
}
