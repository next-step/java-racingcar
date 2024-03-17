package carRace;

import carRace.domain.RaceHost.RaceHost;
import carRace.domain.car.CarGroup;
import carRace.domain.car.CarNames;
import carRace.view.InputView;

public class Main {

    public static void main(String[] args) {
        String input = InputView.inputCarGroupName();
        RaceHost raceHost = new RaceHost(InputView.inputRaceTryCount());

        CarGroup carGroup = new CarGroup(new CarNames(input.split(",")));
        raceHost.playGame(carGroup);
        raceHost.progressAwardsCeremony(carGroup);
    }
}
