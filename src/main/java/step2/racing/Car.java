/*
 * Car.java  1.0.0   2019.10.27
 */
package step2.racing;

import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * 자동차 게임의 대상인 자동차
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class Car {
    private static final int START_INDEX = 0;
    private static final int EXTRA_INDEX_FOR_OPEN_RANGE = 1;

    private Model model;
    private BitSet moveRecord;

    public Car(String model, int round) {
        this.model = new Model(model);
        this.moveRecord = new BitSet(round);
    }

    public static Map<Model, Integer> checkScoreByRound(List<Car> cars, int round) {
        Map<Model, Integer> carScores = new LinkedHashMap<>();
        for (Car car : cars) {
            carScores.put(car.model, car.checkScoreByRound(round));
        }
        return carScores;
    }

    public static List<Model> findWinner(List<Car> cars) {
        int max = calculateMaxScore(cars);
        return cars.stream().filter(car -> car.checkFinalScore() == max)
                .map(car -> car.model)
                .collect(toList());
    }

    private static int calculateMaxScore(List<Car> cars) {
        return cars.stream()
                .map(car -> car.checkFinalScore())
                .max(Integer::compareTo)
                .orElse(0);
    }

    public int checkFinalScore() {
        return moveRecord.cardinality();
    }

    public void move(int round) {
        moveRecord.set(round);
    }

    public int checkScoreByRound(int round) {
        return moveRecord.get(START_INDEX, round + EXTRA_INDEX_FOR_OPEN_RANGE)
                .cardinality();
    }
}