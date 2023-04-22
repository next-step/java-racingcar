import domain.*;
import dto.RaceInfo;
import view.*;

import java.util.List;

public class RaceScenario {
    private static final int INITIAL_POSITION = 1;
    private static final int RANDOM_RANGE = 10;
    private static final int RANDOM_DIVIDING_POINT = 4;

    public static void main(String[] args) {
        InputView<List<CarName>> carNamesInputView = new CarNamesInputView();
        InputView<NumberOfRaces> raceNumberInputView = new RaceNumberInputView();
        ResultView raceResultView = startRace(carNamesInputView.receive(), raceNumberInputView.receive());
        raceResultView.print();
    }

    private static RaceResultView startRace(List<CarName> carNames, NumberOfRaces numberOfRaces) {
        RaceInfo raceInfo = new RaceInfo(
                CarNames.toNumberOfCars(carNames),
                numberOfRaces,
                Car.createCar(DefaultCarState.create(INITIAL_POSITION), RandomCarDisplacement.create(RANDOM_DIVIDING_POINT, RANDOM_RANGE)));

        Race race = new Race(raceInfo);
        return new RaceResultView(race.calculate(), carNames);
    }
}
