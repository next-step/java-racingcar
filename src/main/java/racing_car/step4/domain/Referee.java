package racing_car.step4.domain;

import racing_car.step4.dto.CarDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private final Cars cars;
    
    public Referee(Cars cars) {
        this.cars = cars;
    }
    
    public List<String> getWinnersNameList() {
        return findWinners().stream()
                .map(CarDTO::getCarName)
                .collect(Collectors.toList());
    }
    
    private List<CarDTO> findWinners() {
        return cars.findWinners();
    }
}
