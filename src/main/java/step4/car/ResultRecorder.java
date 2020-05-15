package step4.car;

import java.util.*;
import java.util.stream.Collectors;

public class ResultRecorder {
    private final List<Map<String, Integer>> result;

    public ResultRecorder() {
        this.result = new ArrayList<>();
    }

    public void recordCurrentPosition(List<Car> cars){
        Map<String, Integer> currentPositions = new LinkedHashMap<>(cars.size());
        for (Car car : cars) {
            currentPositions.put(car.getName(), car.getPosition());
        }
        result.add(currentPositions);
    }

    public List<String> findWinners(){
        resultCheck();
        Map<String, Integer> last = result.get(result.size() - 1);

        return last.entrySet().stream()
                .filter(entry -> entry.getValue().equals(findMaxPosition(last)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Map<String, Integer>> getResult() {
        return result;
    }

    private int findMaxPosition(Map<String, Integer> last) {
        return last.values().stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();
    }

    private void resultCheck() {
        if (result.isEmpty()) {
            throw new IllegalStateException("기록된 결과가 없습니다.");
        }
    }
}
