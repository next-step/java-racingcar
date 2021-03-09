package racingcar.domain;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.EachRound;
import racingcar.dto.FinalResult;
import racingcar.dto.InputManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingGame {

    private Cars carGroup;
    private FinalResult finalResult = new FinalResult();
    private int thisRound = 0;

    public List<String> getWinners() {
        Map<String, Integer> finalRound = finalResult.getFinalResult().get(InputManagement.getCountRound());
        int maxPosition = Collections.max(finalRound.values());

        List<Map.Entry<String, Integer>> results = new ArrayList<>(finalRound.entrySet());

        return results.stream()
                .filter((Map.Entry<String, Integer> result) -> result.getValue() == maxPosition)
                .map(result -> result.getKey())
                .collect(Collectors.toList());
    }

    public void recordEachRoundPosition() {
        EachRound eachRound = new EachRound();

        for (Car car : carGroup.getCars()) {
            eachRound.recordRoundPosition(car);
        }

        finalResult.recordRoundPosition(thisRound, eachRound.getResult());
    }

    public void playRacing() {
        carGroup.updateEveryCarByCondition();

        recordEachRoundPosition();
    }

    public boolean hasNextRound() {
        return InputManagement.getCountRound() > thisRound++;
    }

    public Map<Integer, Map<String, Integer>> startRacing(Cars carGroup) {
        this.carGroup = carGroup;

        while (hasNextRound()) {
            playRacing();
        }

        return finalResult.getFinalResult();
    }
}
