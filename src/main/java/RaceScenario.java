import domain.*;
import dto.RaceInfo;
import view.*;

public class RaceScenario {
    public static void main(String[] args) {
        InputView<NumberOfCars> carNumberInputView = new CarNumberInputView();
        InputView<NumberOfRaces> raceNumberInputView = new RaceNumberInputView();
        RaceInfo raceInfo = new RaceInfo(carNumberInputView.receive(), raceNumberInputView.receive(), Car.createCar(DefaultCarState.create(1), DefaultCarDisplacement.create(1)));

        Race race = new Race(raceInfo);
        RaceResult raceResult = race.calculate();

        ResultView raceResultView = new RaceResultView(raceResult);
        raceResultView.print();
    }
}
