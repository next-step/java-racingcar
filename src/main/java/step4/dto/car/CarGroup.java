package step4.dto.car;

import step4.dto.count.Position;
import step4.dto.name.CarNameGroup;
import step4.dto.record.Record;
import step4.dto.count.RandomNumber;
import step4.dto.record.RecordGroup;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class CarGroup {
    List<Car> cars;

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public void run() {
        cars.stream()
                .forEach(car -> car.run(RandomNumber.newRandom()));
    }

    public RecordGroup carsCurrentPosition() {
        return cars.stream()
                .map(car -> new Record(car.getName(), new Position(car.getPosition())))
                .collect(collectingAndThen(toList(), RecordGroup::new));
    }

    public CarNameGroup findWinner() {
        return cars.stream()
                .filter((car) -> car.isMaxPosition(getMaxPosition()))
                .map(car -> car.getName())
                .collect(collectingAndThen(toList(), CarNameGroup::new));
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();

        for(Car car : cars) {
            if(car.isMaxPosition(maxPosition)) {
                maxPosition = car.maxPosition();
            }
        }

        return maxPosition;
    }
}
