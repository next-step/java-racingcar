package racingcar.controller;

import racingcar.dto.RaceReadyValue;
import racingcar.dto.RaceResultValue;
import racingcar.external.InputChannel;
import racingcar.external.InputView;
import racingcar.external.OuputChannel;
import racingcar.external.ResultView;
import racingcar.model.RandomMove;
import racingcar.service.RacingCarService;

public class RacingCarApplication {

    public static void main(String[] args) {
        RaceReadyValue raceReadyValue = InputView.input(new InputChannel());

        RaceResultValue raceResultValue = RacingCarService.play(raceReadyValue, new RandomMove());

        ResultView.output(new OuputChannel(), raceResultValue);
    }
}
