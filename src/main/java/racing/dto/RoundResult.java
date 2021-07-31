package racing.dto;


import racing.domain.Car;
import racing.dto.CarDTO;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {

    private List<CarDTO> cars;
    private List<String> winners;

    public RoundResult(List<Car> cars, List<Car> winners) {
        this.cars = cars.stream().map(CarDTO::new).collect(Collectors.toList());
        this.winners = winners.stream().map(Car::getName).collect(Collectors.toList());
    }

    public List<CarDTO> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return winners;
    }
}
