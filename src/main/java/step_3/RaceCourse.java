package step_3;

import step_3.dto.RaceConfigurationDTO;

import java.util.List;

public class RaceCourse {

    private final List<Car> cars;
    private final RaceConfigurationDTO raceConfigurationDTO;

    public RaceCourse(List<Car> cars, RaceConfigurationDTO raceConfigurationDTO) {
        this.cars = cars;
        this.raceConfigurationDTO = raceConfigurationDTO;
    }

    public void startRace(RaceResultView raceResultView) {
        for (int i = 0; i < raceConfigurationDTO.roundCount(); i++) {
            moveCar();
            raceResultView.saveRaceResult(cars);
        }
    }

    private void moveCar() {
        cars.forEach(Car::move);
    }
}

