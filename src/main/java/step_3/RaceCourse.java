package step_3;

import step_3.dto.RaceConfigurationDTO;

import java.util.List;

public class RaceCourse {

    private final ResultView resultView = new ResultView();

    private final List<Car> cars;
    private final RaceConfigurationDTO raceConfigurationDTO;

    public RaceCourse(List<Car> cars, RaceConfigurationDTO raceConfigurationDTO) {
        this.cars = cars;
        this.raceConfigurationDTO = raceConfigurationDTO;
    }

    public void startRace() {
        for (int i = 0; i < raceConfigurationDTO.roundCount(); i++) {
            moveCar();
            resultView.saveRaceResult(cars);
        }
    }

    private void moveCar() {
        cars.forEach(Car::move);
    }

    public void viewRaceResult() {
        resultView.viewResult();
    }
}

