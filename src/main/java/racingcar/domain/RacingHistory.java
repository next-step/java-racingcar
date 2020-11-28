package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingHistory {

    private Map<Integer, List<Integer>> racingResult;

    public Map<Integer, List<Integer>> getRacingResult(){
        return racingResult;
    }

    public void putRacingResult(int move, List<Integer> result){
        racingResult.put(move, result);
    }

    public RacingHistory(Map<Integer, List<Integer>> racingResult){
        this.racingResult = racingResult;
    }

	public RacingHistory() {
        this.racingResult = new HashMap<>();
	}
    
}