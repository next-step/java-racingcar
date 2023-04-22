import domain.*;
import dto.RaceInfo;
import view.*;

public class RaceScenario {
    private static final int RANDOM_RANGE = 10;
    private static final int RANDOM_DIVIDING_POINT = 4;

    public static void main(String[] args) {
        InputView<NumberOfCars> carNumberInputView = new CarNumberInputView();
        InputView<NumberOfRaces> raceNumberInputView = new RaceNumberInputView();
        RaceInfo raceInfo = new RaceInfo(carNumberInputView.receive(), raceNumberInputView.receive(), Car.createCar(DefaultCarState.create(1), RandomCarDisplacement.create(RANDOM_DIVIDING_POINT, RANDOM_RANGE)));

        Race race = new Race(raceInfo);
        RaceResult raceResult = race.calculate();

        ResultView raceResultView = new RaceResultView(raceResult);
        raceResultView.print();
    }
}
