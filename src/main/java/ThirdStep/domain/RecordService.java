package ThirdStep.domain;

import ThirdStep.domain.strategy.RandomMovingStrategy;
import ThirdStep.domain.model.Car;
import ThirdStep.domain.model.RecordByCar;

import java.util.List;
import java.util.stream.Collectors;

public class RecordService {
    private static final int START_LOCATION = 0;

    public List<RecordByCar> initRecordByCars(List<Car> cars) {
        return cars.stream()
                .map(car -> new RecordByCar(car, START_LOCATION))
                .collect(Collectors.toList());
    }

    public List<RecordByCar> generateRecordByCar(List<RecordByCar> recordByCars) {
        return recordByCars
                .stream()
                .map(recordByCar -> new RecordByCar(
                        recordByCar.getCar(),
                        recordByCar.getLocation() + CarService.movedDistance(RandomMovingStrategy.create()))
                )
                .collect(Collectors.toList());
    }
}
