package racing;

import java.util.List;
import java.util.Map;

public class RacingGameResult {
    private Map<Integer, Map<Car,Boolean>> roundHistory;
    private List<String> winners;
    private int time;

    public RacingGameResult(Map<Integer, Map<Car,Boolean>> roundHistory,List<String> winners, int time) {
        this.roundHistory = roundHistory;
        this.winners = winners;
        this.time = time;
    }

    public int getTime(){
        return this.time;
    }

    public Map<Integer, Map<Car,Boolean>> getRoundHistory(){
        return this.roundHistory;
    }

    public List<String> getWinners(){
        return this.winners;
    }
}
