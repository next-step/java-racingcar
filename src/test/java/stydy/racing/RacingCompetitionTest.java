package stydy.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racing.controller.RacingCompetition;
import study.racing.domain.Car;
import study.racing.domain.CarRaceInput;
import study.racing.domain.RacingHistory;
import study.racing.service.RacingGameWinnerService;
import study.racing.strategy.MoveUnderOneDigitStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCompetitionTest {
    private RacingGameWinnerService racingGameWinnerService;

    @BeforeEach
    public void setData() {
        String inputValues = "a,b,c";
        List<String> carNames = Arrays.stream(inputValues.trim().split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        CarRaceInput carRaceInput = new CarRaceInput(carNames, carNames.size(), 5);
        racingGameWinnerService = new RacingGameWinnerService(carRaceInput);
    }

    @Test
    @DisplayName("우승자 찾기")
    public void findWinner() {

        RacingHistory racingHistory = racingGameWinnerService.raceStart(new MoveUnderOneDigitStrategy());

        List<Car> winners = racingGameWinnerService.findWinners(racingHistory);

        int maxMoveCount = winners.get(0).getMoveCount();
        assertThat(winners).isNotEmpty();
        assertThat(winners).allMatch(car -> car.getMoveCount() == maxMoveCount);
        assertThat(winners).extracting(Car::getCarName).contains("a", "b", "c");
    }

    @Test
    @DisplayName("자동차 경주가 잘 출력되는지 확인")
    public void racing() {
        RacingCompetition racingCompetition = new RacingCompetition();
        racingCompetition.racing();
   }
}
