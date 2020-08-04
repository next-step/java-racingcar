package racingcar.game;

import org.apache.commons.lang3.StringUtils;
import racingcar.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private List<String> statusList;

    private Result(Cars cars) {
        this.statusList = cars.getCars().stream()
                .map(car -> StringUtils.repeat("-", car.getPosition()))
                .collect(Collectors.toList());
    }

    public static Result newInstance(Cars cars) {
        return new Result(cars);
    }

    public List<String> getStatusList() {
        return statusList;
    }
}
