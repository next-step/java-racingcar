/*
 * Car.java  1.0.0   2019.10.27
 */
package step2.racing;


import step2.move.MoveStrategy;

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
    private BitSet moveSet;

    public Car(String model, int turn) {
        this.model = new Model(model);
        this.moveSet = new BitSet(turn);
    }

    public static Map<Model, Integer> scoreByTurn(List<Car> cars, int turn) {
        Map<Model, Integer> carScores2 = new LinkedHashMap<>();
        cars.forEach(car -> {
            carScores2.put(car.model, car.getScoreByTurn(turn));
        });
        return carScores2;
    }

    public static List<Model> winners(List<Car> cars) {
        int max = maxScore(cars);
        return cars.stream().filter(car -> car.getFinalScore() == max)
                .map(car -> car.model)
                .collect(toList());
    }

    public static int maxScore(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getFinalScore())
                .max(Integer::compareTo)
                .orElse(0);
    }

    public int getFinalScore() {
        return moveSet.cardinality();
    }

    public void move(MoveStrategy moveStrategy, int turn) {
        if (moveStrategy.isPossibleToGo()) {
            moveSet.set(turn);
        }
    }

    public int getScoreByTurn(int turn) {
        return moveSet.get(START_INDEX, turn + EXTRA_INDEX_FOR_OPEN_RANGE)
                .cardinality();
    }
}