package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {
    private int numberOfTries;
    private StrategyGenerator strategyGenerator;
    private List<Car> cars = new ArrayList<>();

    public Racing(List<String> carNames, int numberOfTries, StrategyGenerator strategyGenerator){
        this.numberOfTries = numberOfTries;
        this.strategyGenerator = strategyGenerator;

        for(int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(carNames.get((i))));
        }
    }

    public RacingResult race() {
        RacingResult racingResult = new RacingResult();

        makeMovingHistoryByTry(racingResult);
        decideWinners(racingResult);

        return racingResult;
    }

    private void makeMovingHistoryByTry(RacingResult racingResult){
        for(int i = 0; i < numberOfTries; i++) {
            Map<String,Integer> resultMap = fetchMovingResult();
            racingResult.addMovingHistoryByTry(resultMap);
        }
    }

    private void decideWinners(RacingResult racingResult) {
        int max = cars.stream().mapToInt(car -> car.getNumberOfMoves()).max().getAsInt();
        List<String> winners = cars.stream().filter(car -> car.getNumberOfMoves() == max)
                .map(car -> car.getName())
                .collect(Collectors.toList());

        racingResult.setWinners(winners);
    }

    private Map<String, Integer> fetchMovingResult() {
        Map<String, Integer> resultMap = new LinkedHashMap<>();

        for(Car car : cars){
            car.move(strategyGenerator.generate());
            resultMap.put(car.getName(), car.getNumberOfMoves());
        }

        return resultMap;
    }
}
