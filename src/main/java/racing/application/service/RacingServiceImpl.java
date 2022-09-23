package racing.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racing.application.view.Score;
import racing.domain.car.Car;
import racing.domain.car.CarRace;

public class RacingServiceImpl implements RacingService {

    @Override
    public CarRace makeCars(int count) {
        List<Car> carList = IntStream.range(0, count)
            .mapToObj(i -> new Car())
            .collect(Collectors.toList());

        return new CarRace(carList);
    }

    @Override
    public Score scoreBoard(CarRace carRace, int moveCount) {
        List<CarRace> carRaceList = new ArrayList<>();

        CarRace current = carRace;

        for (int i = 0; i < moveCount; i++) {
            current = current.move();
            carRaceList.add(current);
        }

        return new Score(carRaceList);
    }
}
