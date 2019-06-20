package racing.domain;

public class RacingResult {
    private final MovingHistory movingHistory;
    private final String winnerNames;
    
    public RacingResult(MovingHistory movingHistory, String winnerNames) {
        this.movingHistory = movingHistory;
        this.winnerNames = winnerNames;
    }
    
    public MovingHistory getMovingHistory() {
        return movingHistory;
    }
    
    public String getWinnerNames() {
        return winnerNames;
    }
}
