package racinggame;

import racinggame.controller.RaceController;
import racinggame.dto.RaceResultDTO;
import racinggame.service.RaceService;
import racinggame.view.RaceInputReader;
import racinggame.view.RaceResultView;

public class RaceRunner {

    public static void main(String[] args) {
        RaceController raceController = new RaceController(new RaceService());
        RaceResultDTO raceResultDTO = raceController.start(RaceInputReader.raed());

        RaceResultView raceResultView = new RaceResultView();
        raceResultView.readRaceResult(raceResultDTO);
        raceResultView.printResult();
    }
}
