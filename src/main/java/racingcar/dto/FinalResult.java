package racingcar.dto;

import java.util.HashMap;
import java.util.Map;

public class FinalResult {

    private Map<Integer, Map<String, Integer>> finalResult = new HashMap();

    public Map<Integer, Map<String, Integer>> getFinalResult() {
        return finalResult;
    }

    public void recordRoundPosition(int roundNumber, Map<String, Integer> eachRoundRecord) {
        finalResult.put(roundNumber, eachRoundRecord);
    }
}
