import domain.*;
import view.*;

import java.util.List;

public class RaceScenario {
    public static void main(String[] args) {
        InputView<CarNumber> carNumberInputView = new CarNumberInputView();
        InputView<RaceNumber> raceNumberInputView = new RaceNumberInputView();
        RaceInfo raceInfo = new RaceInfo(carNumberInputView.receive(), raceNumberInputView.receive());

        Race race = new Race(raceInfo);
        RaceResult raceResult = race.calculate();

        ResultView raceResultView = new RaceResultView(raceResult);
        raceResultView.print();
    }
}
