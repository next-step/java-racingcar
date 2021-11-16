package racingcar.domain.dto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;

public class ResultDto {

    private final Winners winners;
    private final List<Car> cars;
    private final long tryCountTotal;

    private ResultDto(Cars cars) {
        this.cars = cars.getCars();
        this.tryCountTotal = cars.getTryCountTotal();
        this.winners = Winners.from(this.cars);
    }

    public static ResultDto from(Cars cars) {
        return new ResultDto(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public long getTryCountTotal() {
        return tryCountTotal;
    }

    public List<Car> getWinners() {
        return winners.getWinners();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultDto resultDto = (ResultDto) o;
        return tryCountTotal == resultDto.tryCountTotal && Objects.equals(winners, resultDto.winners)
            && Objects.equals(cars, resultDto.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners, cars, tryCountTotal);
    }
}
