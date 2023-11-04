package step3;

import java.util.Map;

public class CarRacingPlay {

    private final int MAX_RACE_RANDOM_VALUE = 9;
    private final int MIN_RACE_CONDITION = 4;

    private RandomValueGenerator randomValueGenerator;

    public CarRacingPlay(RandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    public void race(int carNumber, Map<Integer, Integer> racingBoard) {
        double randomValue = randomValueGenerator.generateRandomValue();
        if (checkRacingCondition(getRacingConditionValue(randomValue))) {
            racingBoard.put(carNumber, racingBoard.get(carNumber) + 1);
        }
    }

    public int getRacingConditionValue(double randomValue) {
        return (int) (randomValue * (MAX_RACE_RANDOM_VALUE + 1));
    }

    public boolean checkRacingCondition(int randomValue) {
        return randomValue >= MIN_RACE_CONDITION;
    }


}
