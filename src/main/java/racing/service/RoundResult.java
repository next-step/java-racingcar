package racing.service;

import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoundResult {
    private Round round;

    private List<CarDto> carDtos;

    private RoundResult(Round round, List<CarDto> carDtos) {
        this.round = round;
        this.carDtos = carDtos;
    }

    public static RoundResult of(Round round, List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();
        cars.forEach(car -> carDtos.add(CarDto.of(car)));
        return new RoundResult(round, carDtos);
    }

    public List<CarDto> getCarDtos() {
        return carDtos;
    }

    public Round getRound() {
        return round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundResult that = (RoundResult) o;
        return Objects.equals(round, that.round) && Objects.equals(carDtos, that.carDtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round, carDtos);
    }
}
