package racingcar.domain;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.InputManagement;

import java.util.*;
import java.util.stream.Collectors;

public class FinalResult {

    private Map<Integer, Map<String, Integer>> finalResult = new HashMap();

    public Map<Integer, Map<String, Integer>> getFinalResult() {
        return finalResult;
    }

    public void recordRoundPosition(int roundNumber, Map<String, Integer> eachRoundRecord) {
        finalResult.put(roundNumber, eachRoundRecord);
    }

    public Cars getWinnersInCars() {
        Map<String, Integer> finalRound = finalResult.get(finalResult.size());

        int maxPosition = Collections.max(finalRound.values());

        List<Map.Entry<String, Integer>> results = new ArrayList<>(finalRound.entrySet());

        return new Cars(results.stream()
                .filter((Map.Entry<String, Integer> result) -> result.getValue() == maxPosition)
                .map(result -> new Car(result.getKey(), result.getValue()))
                .collect(Collectors.toList()));
    }
}
