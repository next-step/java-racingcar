package racingGame.Response;


import java.util.ArrayList;
import java.util.List;
import racingGame.model.ProgressRecord;

public record GameResult(List<ProgressRecord> progressRecords) {
    
    public GameResult(List<ProgressRecord> progressRecords) {
        this.progressRecords = new ArrayList<>(progressRecords);
    }
    
    @Override
    public List<ProgressRecord> progressRecords() {
        return List.copyOf(progressRecords);
    }

}
