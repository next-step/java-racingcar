package racing;

import java.util.*;
import java.util.stream.Collectors;

public class CarRace {
    Winners getWinners(Cars cars) {
        MaxPosition maxPosition;

        Collections.sort(cars.getCars());
        maxPosition = new MaxPosition(cars.getCars().get(0).getPosition());

        return new Winners(cars.getCars().stream()
                .filter(p -> p.getPosition() == maxPosition.getMaxPosition())
                .collect(Collectors.toList()));
    }
}