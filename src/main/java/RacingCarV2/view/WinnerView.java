package RacingCarV2.view;

import RacingCarV2.model.Car;
import RacingCarV2.model.CarDTO;
import RacingCarV2.model.StageResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerView {

    private static final String END_MESSAGE = " 최중 우승하였습니다.";

    private List<StageResult> stageResults;

    public WinnerView(List<StageResult> stageResults) {
        this.stageResults = stageResults;
    }

    void print() {
        List<String> winners = getWinners(stageResults);
        System.out.println(winners.toString() + END_MESSAGE);
    }

    List<String> getWinners(List<StageResult> stageResults) {
        Map<String, Integer> map = new HashMap<>();

        for (StageResult stageResult : stageResults) {
            sumStageResult(stageResult, map);
        }

        return getKeysFromValue(map,getMaxPosition(map));
    }

    private void sumStageResult(StageResult result, Map<String, Integer> map) {
        for (CarDTO car : result.getCars()) {
            sumStagePosition(map, car);
        }
    }
    private void sumStagePosition(Map<String, Integer> map, CarDTO car) {
        if (map.containsKey(car.getName())) {
            int count = map.get(car.getName()) + car.getPosition();
            map.put(car.getName(), count);
            return;
        }

        map.put(car.getName(), car.getPosition());
    }

    public int getMaxPosition(Map<String, Integer> map) {
        int max = Integer.MIN_VALUE;
        for (int position: map.values()) {
            max = getBigInteger(position, max);
        }
        return max;
    }

    private List<String> getKeysFromValue(Map<String, Integer> map, int value) {
        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            boolean isAdd = map.get(key).equals(value);
            addTargetValue(list, key, isAdd);
        }
        return list;
    }

    private void addTargetValue(List<String> list, String key, boolean isPush) {
        if (isPush) {
            list.add(key);
        }
    }

    int getBigInteger(int position, int max) {
        return position > max ? position : max;
    }
}
