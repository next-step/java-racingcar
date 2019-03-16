package racing;

import java.util.List;

public class RacingGameResult {
    private List<CarRoundResult> roundHistory;
    private int time;

    public RacingGameResult(List<CarRoundResult> roundHistory, int time) {
        this.roundHistory = roundHistory;
        this.time = time;
    }

    public int getTime(){
        return this.time;
    }

    public List<CarRoundResult> printRoundHistory(){
        return this.roundHistory;
    }
}
