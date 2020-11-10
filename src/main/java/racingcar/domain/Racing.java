package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {
    private int numberOfTries;
    private StrategyGenerator strategyGenerator;
    private RacingResult racingResult;
    private List<Car> cars = new ArrayList<>();


    public Racing(List<String> carNames, int numberOfTries){
        this.numberOfTries = numberOfTries;
        this.racingResult = new RacingResult();

        for(int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(carNames.get((i))));
        }
    }

    public RacingResult getRacingResult(){
        return racingResult;
    }

    public void setStrategyGenerator(StrategyGenerator strategyGenerator) {
        this.strategyGenerator = strategyGenerator;
    }

    public void race() {
        clearRacingResultAndWinners();
        makeMovingHistoryByTry();
        decideWinners();
    }

    private void clearRacingResultAndWinners(){
        racingResult.clear();
    }

    private void makeMovingHistoryByTry(){
        for(int i = 0; i < numberOfTries; i++) {
            Map<String,Integer> resultMap = fetchMovingResult();
            racingResult.addMovingHistoryByTry(resultMap);
        }
    }

    private void decideWinners() {
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
