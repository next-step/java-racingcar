package stydy.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racing.InputView;
import study.racing.controller.RacingCompetition;
import study.racing.domain.Car;
import study.racing.domain.CarRaceInput;
import study.racing.domain.RacingHistory;
import study.racing.service.RacingGameWinnerService;
import study.racing.strategy.MoveUnderOneDigitStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCompetitionTest {


    @Test
    @DisplayName("우승자 찾기")
    public void findWinner() {

        InputView inputView = new InputView();
        CarRaceInput carRaceInput = inputView.collectUserInput();
        RacingGameWinnerService racingGameWinnerService = new RacingGameWinnerService();
        RacingHistory racingHistory = racingGameWinnerService.raceStart(carRaceInput, new MoveUnderOneDigitStrategy());

        List<Car> winners = racingGameWinnerService.findWinners(carRaceInput.getCarCount(),racingHistory);

        int maxMoveCount = winners.get(0).getMoveCount();
        assertThat(winners).isNotEmpty();
        assertThat(winners).allMatch(car -> car.getMoveCount() == maxMoveCount);
    }

    @Test
    @DisplayName("자동차 경주가 잘 출력되는지 확인")
    public void racing() {
        RacingCompetition racingCompetition = new RacingCompetition();
        racingCompetition.racing();
   }
}
