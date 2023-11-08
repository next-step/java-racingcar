package com.racing.game.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    private int[][] raceRecord;

    private RaceResult(int[][] raceRecord) {
        this.raceRecord = raceRecord;
    }

    public static RaceResult of(int[][] raceRecord) {
        return new RaceResult(raceRecord);
    }

    public List<List<Integer>> toResultForm() {
        List<List<Integer>> result = Arrays.stream(raceRecord).map(value -> Arrays.stream(value).boxed().collect(
                Collectors.toList())).collect(Collectors.toList());
        for (int tryIndex = 1; tryIndex < raceRecord.length; tryIndex++) {
            toIntegratedRecord(result, tryIndex);
        }
        return result;
    }

    private void toIntegratedRecord(List<List<Integer>> result, int tryIndex) {
        for (int carIndex = 0; carIndex < result.get(tryIndex).size(); carIndex++) {
            result.get(tryIndex)
                    .set(carIndex, result.get(tryIndex).get(carIndex) + result.get(tryIndex - 1).get(carIndex));
        }
    }
}
