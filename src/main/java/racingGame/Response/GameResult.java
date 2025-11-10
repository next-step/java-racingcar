package racingGame.Response;


import java.util.ArrayList;
import java.util.List;
import racingGame.model.ProgressRecord;

public class GameResult {
    private final List<ProgressRecord> progressRecords;
    
    public GameResult(List<ProgressRecord> progressRecords) {
        this.progressRecords = new ArrayList<>(progressRecords);
    }
    
    public List<ProgressRecord> getProgressRecords() {
        return List.copyOf(progressRecords);
    }
    
}
