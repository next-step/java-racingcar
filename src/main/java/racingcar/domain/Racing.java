package racingcar.domain;

import racingcar.common.Constants;

import java.util.*;

public class Racing {
    private int numberOfTries;
    private StrategyGenerator strategyGenerator;
    private List<Car> cars = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public Racing(List<String> carNames, int numberOfTries){
        this.numberOfTries = numberOfTries;

        for(int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(carNames.get((i))));
        }
    }

    public void setStrategyGenerator(StrategyGenerator strategyGenerator) {
        this.strategyGenerator = strategyGenerator;
    }

    public String race() {
        for(int i = 0; i < numberOfTries; i++) {
            cars.stream().map(c -> c.move(strategyGenerator.generate())).forEach(sb::append);
            sb.append(Constants.NEW_LINE_DELIMITER);
        }

        int max = cars.stream().mapToInt(car -> car.getNumberOfMoves()).max().getAsInt();
        String[] winnerNames = cars.stream().filter(car -> car.getNumberOfMoves() == max)
                .map(car -> car.getName())
                .toArray(String[]::new);

        sb.append(String.join(Constants.COMMA_DELIMITER.concat(Constants.WHITE_SPACE_DELIMITER), winnerNames))
          .append(Constants.THE_WINNER_IS);

        return sb.toString();
    }
}
