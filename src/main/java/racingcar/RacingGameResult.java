package racingcar;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RacingGameResult {

    private final Map<String, List<Integer>> results = new HashMap<>();

    public List<Integer> add(String carName, Integer record) {
        if (results.containsKey(carName)) {
            List<Integer> records = results.get(carName);
            records.addAll(Arrays.asList(record));
            return records;
        }
        return results.put(carName, new ArrayList<>(Arrays.asList(record)));
    }

    public void addFromCars(Cars cars) {
        cars.getCars().forEach(car -> add(car.getName(), car.getPosition()));
    }

    public Map<String, List<Integer>> getResults() {
        return results;
    }

    public List<String> getWinner() {
        return results.values()
                .stream()
                .flatMap(list -> Stream.of(list.get(list.size() - 1)))
                .max(Comparator.comparing(Integer::valueOf))
                .map(max -> getWinnerCarNames(max))
                .orElse(Collections.EMPTY_LIST);
    }


    private List<String> getWinnerCarNames(Integer max) {
        return results.entrySet()
                .stream()
                .filter(entry -> entry.getValue().contains(max))
                .map(Map.Entry::getKey)
                .collect(toList());
    }

}
