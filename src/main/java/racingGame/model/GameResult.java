package racingGame.model;


import java.util.ArrayList;
import java.util.List;

public record GameResult(List<ProgressRecord> progressRecords) {
    
    public GameResult(List<ProgressRecord> progressRecords) {
        this.progressRecords = new ArrayList<>(progressRecords);
    }
    
    

}
