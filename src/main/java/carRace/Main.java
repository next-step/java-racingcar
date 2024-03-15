package carRace;

import carRace.domain.RaceHost.RaceHost;
import carRace.domain.car.CarGroups;
import carRace.domain.car.CarNames;
import carRace.view.InputView;

public class Main {

    public static void main(String[] args) {
        String input = InputView.inputCarsName();
        RaceHost raceHost = new RaceHost(InputView.inputRaceTryCount());

        CarGroups carGroups = new CarGroups(new CarNames(input.split(",")));
        raceHost.playGame(carGroups);
        raceHost.progressAwardsCeremony(carGroups);
    }
}
