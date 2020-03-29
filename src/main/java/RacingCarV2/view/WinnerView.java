package RacingCarV2.view;

import RacingCarV2.model.Car;
import RacingCarV2.model.StageResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerView {

    private List<StageResult> stageResults;

    public WinnerView(List<StageResult> stageResults) {
        this.stageResults = stageResults;
    }

    void print() {
        List<String> winners = getWinners(stageResults);
        System.out.println(winners.toString() + " 최종 우승하였습니다.");
    }

    List<String> getWinners(List<StageResult> stageResults) {
        Map<String, Integer> map = new HashMap<>();

        for (StageResult stageResult : stageResults) {
            sumStageResult(stageResult, map);
        }

        return getKeysFromValue(map,getMaxPosition(map));
    }

    private void sumStageResult(StageResult result, Map<String, Integer> map) {
        for (Car car : result.getCars()) {
            sumStagePosition(map, car);
        }
    }
    private void sumStagePosition(Map<String, Integer> map, Car car) {
        if (map.containsKey(car.getName())) {
            int count = map.get(car.getName()) + car.getPosition();
            map.put(car.getName(), count);
            return;
        }

        map.put(car.getName(), car.getPosition());
    }

    int getMaxPosition(Map<String, Integer> map) {
        int max = Integer.MIN_VALUE;
        for (int position: map.values()) {
            if (position > max) {
                max = position;
            }
        }
        return max;
    }

    private List<String> getKeysFromValue(Map<String, Integer> map, int value) {
        List<String> list = new ArrayList<>();
        for (Object key : map.keySet()) {
            if (map.get(key).equals(value)) {
                list.add(key.toString());
            }
        }
        return list;
    }
}
