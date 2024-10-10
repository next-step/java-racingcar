package racing.domain.car;

import racing.domain.dto.CarDTO;
import racing.domain.game.Calculator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> items;

    public Cars(List<Car> items) {
        this.items = items;
    }

    public List<CarDTO> toCarDTO() {
        List<CarDTO> newCars = new ArrayList<>();
        for (Car car : items) {
            newCars.add(new CarDTO(car.getName(), car.getPosition()));
        }
        return newCars;
    }

    public Cars carGoAndStop(Calculator calculator) {
        for (Car item : items) {
            item.isGo(calculator.getRandomNumber());
        }
        return this;
    }

    public List<Car> getItems() {
        return items;
    }
}
