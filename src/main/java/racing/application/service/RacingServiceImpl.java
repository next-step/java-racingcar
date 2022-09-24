package racing.application.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing.application.view.Score;
import racing.application.view.Winner;
import racing.domain.car.Car;
import racing.domain.car.CarRace;

public class RacingServiceImpl implements RacingService {

    @Override
    public CarRace makeCars(String names) {
        String[] splitName = names.split(",");

        List<Car> carList = Arrays.stream(splitName)
            .map(Car::new)
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

        return new Score(carRaceList, new Winner(current.winner()));
    }
}
