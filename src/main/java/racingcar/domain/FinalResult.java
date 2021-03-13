package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class FinalResult {

    private Map<Round, Map<Name, Position>> finalResult = new LinkedHashMap();

    public Map<Round, Map<Name, Position>> getFinalResult() {
        return finalResult;
    }

    public void recordRoundPosition(Round round, Map<Name, Position> eachRoundRecord) {
        finalResult.put(new Round(round.getRound()), eachRoundRecord);
    }

    public Cars getWinnersInCars() {
        Map<Name, Position> finalRound = finalResult.get(finalResult.keySet()
                                                                        .stream()
                                                                            .filter(c -> c.getRound() == finalResult.size())
                                                                            .findFirst()
                                                                            .orElse(null));

        int maxPosition = Collections.max(finalRound.values()
                                                        .stream()
                                                            .map(c -> c.getPosition())
                                                            .collect(Collectors.toList()));

        List<Map.Entry<Name, Position>> results = new ArrayList<>(finalRound.entrySet());

        return new Cars(results.stream()
                .filter((Map.Entry<Name, Position> result) -> result.getValue()
                                                                        .getPosition() == maxPosition)
                .map(result -> new Car(result.getKey()
                                                .toString()
                                        , result.getValue()
                                                    .getPosition()))
                .collect(Collectors.toList()));
    }
}
