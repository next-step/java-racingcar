package RacingCar;

import RacingCar.model.Car;
import RacingCar.model.Result;

import java.util.*;

public class ResultView {

    public void print(List<Result> results) {
        results.forEach(stage -> printStageResult(stage));
        printRaceWinners(results);
    }

    private void printStageResult(Result result) {
        result.getCars().forEach(car -> {
            System.out.print(car.getName() + " : ");
            System.out.println(getMoveString(car.getMove()));
        });
        System.out.println();
    }

    private void printRaceWinners(List<Result> results) {
        final String WINNERS_MESSAGE = "가 최종 우승했습니다.";

        List<String> winners = getWinners(results);
        System.out.println(winners.toString() + WINNERS_MESSAGE);
    }

    private List<String> getWinners(List<Result> results) {
        Map<String, Integer> map = new HashMap<>();

        for (Result result : results) {
            sumStage(result, map);
        }

        return getKeysFromValue(map,getMaxMove(map));
    }

    private void sumStage(Result result, Map<String, Integer> map) {
        for (Car car : result.getCars()) {
            sumStageMove(map, car);
        }
    }

    private void sumStageMove(Map<String, Integer> map, Car car) {
        if (map.containsKey(car.getName())) {
            int count = map.get(car.getName()) + car.getMove();
            map.put(car.getName(), count);
            return;
        }

        map.put(car.getName(), car.getMove());
    }

    private int getMaxMove(Map<String, Integer> map) {
        int max = Integer.MIN_VALUE;
        for (int move: map.values()) {
            if (move > max) {
                max = move;
            }
        }
        return max;
    }

    private String getMoveString(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append('-');
        }
        return stringBuilder.toString();
    }

    private List<String> getKeysFromValue(Map map, int value) {
        List<String> list = new ArrayList<>();
        for (Object key : map.keySet()) {
            if (map.get(key).equals(value)) {
                list.add(key.toString());
            }
        }
        return list;
    }

}