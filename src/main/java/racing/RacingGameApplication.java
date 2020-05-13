package racing;

import racing.domain.RacingGame;
import racing.domain.RandomMovement;
import racing.dto.RacingCreateDto;
import racing.dto.RacingResultDto;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.Random;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCreateDto racingCreateDto = inputView.input();

        RacingGame racingGame = new RacingGame(racingCreateDto, new RandomMovement(new Random()));

        OutputView outPutView = new OutputView();

        RacingResultDto racingResultDto;
        for (int i = 0; i < racingCreateDto.totalRacingCount(); i++) {
            racingGame.executeRacing();
            racingResultDto = new RacingResultDto(racingGame);
            outPutView.printRacingResult(racingResultDto);
        }
    }
}
