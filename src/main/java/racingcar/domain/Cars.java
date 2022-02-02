package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.controller.ResultDto;
import racingcar.domain.movable.MovableStrategy;

public class Cars {

    private static final String NAME_SPLITTER = ",";

    private final List<Car> carList;

    private List<ResultDto> result;

    public Cars(final String carList) {
        this(Arrays.stream(carList.split(NAME_SPLITTER))
            .map(String::trim)
            .map(Car::new)
            .collect(Collectors.toList()));
    }

    public Cars(final List<Car> carList) {
        validateCarExists(carList);
        this.carList = carList;
        this.result = new ArrayList<>();
    }

    public List<ResultDto> moveAll(final MovableStrategy strategy, Turn turn) {
        while (!turn.isTurnEnd()) {
            result = Stream.concat(result.stream(), carList.stream().map(car -> {
                        car.run(strategy);
                        return new ResultDto(car.name(), car.distance());
                    })
                )
                .collect(Collectors.toList());
            turn.runGame();
        }
        return result;
    }

    public List<Car> get() {
        return Collections.unmodifiableList(carList);
    }

    public int size() {
        return carList.size();
    }

    public List<Car> getWinnerList() {
        int max = calculateMax();
        return carList.stream()
            .filter(car -> car.isDistance(max))
            .collect(Collectors.toList());
    }

    private void validateCarExists(final List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 플레이어가 존재하지 않습니다.");
        }
    }

    private int calculateMax() {
        return carList.stream()
            .mapToInt(Car::distance)
            .max()
            .orElseThrow(
                () -> new IllegalArgumentException("[ERROR] 예외가 발생하였습니다 : max 값이 존재하지 않습니다."));
    }
}
