package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.domain.Position;

import java.util.LinkedHashMap;
import java.util.Map;

public class EachRound {

    private Map<Name, Position> result = new LinkedHashMap<>();

    public Map<Name, Position> getResult() {
        return result;
    }

    public void recordRoundPosition(Car car) {
        result.put(new Name(car.getName()
                                    .toString()), new Position(car.getPosition()
                                                                        .getPosition()));
    }
}
