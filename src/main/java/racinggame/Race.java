package racinggame;

import racinggame.dto.RaceConfigurationDTO;

import java.util.List;

public class Race {

    private final RaceResultView raceResultView;
    private final RaceConfigurationScanner raceConfigurationScanner;

    public Race(RaceResultView raceResultView, RaceConfigurationScanner raceConfigurationScanner) {
        this.raceResultView = raceResultView;
        this.raceConfigurationScanner = raceConfigurationScanner;
    }

    public void start() {
        RaceConfigurationDTO raceConfigurationDTO = raceConfigurationScanner.scan();

        List<Car> cars = CarFactory.produce(raceConfigurationDTO);

        RaceCourse raceCourse = new RaceCourse(cars, raceConfigurationDTO);
        raceCourse.startRace(raceResultView);

        raceResultView.viewResult();
        System.out.println("종료");
    }
}
