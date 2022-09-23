package racinggame;

import racinggame.dto.RaceConfigurationDTO;

import java.util.List;

public class Race {

    public static void main(String[] args) {
        Race race = new Race();
        race.start();
    }

    private void start() {
        RaceResultView raceResultView = new RaceResultView();
        RaceConfigurationScanner raceConfigurationScanner = new RaceConfigurationScanner();

        RaceConfigurationDTO raceConfigurationDTO = raceConfigurationScanner.scan();

        List<Car> cars = CarFactory.produce(raceConfigurationDTO);

        RaceCourse raceCourse = new RaceCourse(cars, raceConfigurationDTO);
        raceCourse.startRace(raceResultView);

        raceResultView.viewResult();
        System.out.println("종료");
    }

}
