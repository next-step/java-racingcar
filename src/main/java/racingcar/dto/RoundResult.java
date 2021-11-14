package racingcar.dto;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.Car;

public class RoundResult {

    private final Map<String, Integer> records = new LinkedHashMap<>();

    public List<String> results() {
        return records.keySet().stream()
            .map(carName ->
                MessageFormat.format("{0} : {1}", carName, getCarLocation(carName)))
            .collect(Collectors.toList());
    }

    private String getCarLocation(String carName) {
        return IntStream.range(0, records.get(carName))
            .boxed()
            .map(i -> "-")
            .collect(Collectors.joining());
    }

    public void record(Car car) {
        records.put(car.getName(), car.getPosition());
    }
}
