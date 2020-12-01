package com.nextstep.racingcar.domain.round;

import com.nextstep.racingcar.domain.car.Cars;
import com.nextstep.racingcar.domain.car.MoveLength;
import com.nextstep.racingcar.domain.car.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private Cars cars;

    private Round(Cars cars) {
        this.cars = cars;
    }

    public static Round newRound(Cars cars) {
        return new Round(cars);
    }

    public int getCarNumber() {
        return this.cars.size();
    }

    public void moveAll(MoveStrategy moveStrategy) {
        this.cars.moveAll(moveStrategy);
    }

    public List<MoveLength> getResult() {
        return this.cars.getMoveLengths();
    }

    public String getTotalResult() {
        StringBuilder result = new StringBuilder();
        for (MoveLength moveLength : this.cars.getMoveLengths()) {
            result.append(moveLength.toStringLength()).append("\n");
        }
        return result.toString();
    }

    public List<CarRoundResult> getRoundResults() {
        return cars.getCars()
                .stream()
                .map(car -> CarRoundResult.create(car.getDriverName(), car.getMoveLength()))
                .collect(Collectors.toList());
    }
}
