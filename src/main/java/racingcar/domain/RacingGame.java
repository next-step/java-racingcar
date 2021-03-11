package racingcar.domain;

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
    private InputManagement inputManagement;
    private FinalResult finalResult = new FinalResult();
    private int thisRound = 0;

    public Cars getWinners() {
        Map<String, Integer> finalRound = finalResult.getFinalResult()
                                                        .get(inputManagement.getCountRound());

        int maxPosition = Collections.max(finalRound.values());

        List<Map.Entry<String, Integer>> results = new ArrayList<>(finalRound.entrySet());

        return new Cars(results.stream()
                                    .filter((Map.Entry<String, Integer> result) -> result.getValue() == maxPosition)
                                    .map(result -> new Car(result.getKey(), result.getValue()))
                                    .collect(Collectors.toList()));
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
        return inputManagement.getCountRound() > thisRound++;
    }

    public FinalResult startRacing() {
        while (hasNextRound()) {
            playRacing();
        }

        return finalResult;
    }

    public void init(Cars carGroup, InputManagement inputManagement) {
        this.carGroup = carGroup;
        this.inputManagement = inputManagement;
    }
}
