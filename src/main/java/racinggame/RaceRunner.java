package racinggame;

import racinggame.controller.RaceController;
import racinggame.dto.RaceResultDTO;
import racinggame.service.RaceService;
import racinggame.view.RaceResultView;

public class RaceRunner {

    public static void main(String[] args) {
        RaceController race = new RaceController(new RaceService());
        RaceResultDTO raceResultDTO = race.start(RaceInputReader.raed());

        RaceResultView raceResultView = new RaceResultView();
        raceResultView.readRaceReslut(raceResultDTO);
        raceResultView.printResult();
    }
}
