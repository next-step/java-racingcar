package racing;

import racing.exception.DuplicatedCarException;

import java.util.*;

public class RacingGameStatus {
    Map<UUID, List<CarDriving>> carStatuses = new HashMap<>();

    public void addCar(UUID carId) {
        if (carStatuses.containsKey(carId)) {
            throw new DuplicatedCarException(carId);
        }

        carStatuses.put(carId, new ArrayList<>());
    }

    public void addStatus(UUID carId, CarDriving carDriving) {
        carStatuses.get(carId).add(carDriving);
    }

    public List<CarDriving> getStatus(UUID carId) {
        return carStatuses.get(carId);
    }
}
