package racingCar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.service.GameService;

class WinnerTest {

  @Test
  @DisplayName("우승자 테스트")
  void winnerTest() {
    List<Car> gameParticipants = Arrays.asList(
        new Car("a", new Position(1)),
        new Car("b", new Position(2)),
        new Car("c", new Position(4)),
        new Car("d", new Position(3)));
    GameService gameService = new GameService();
    Winner winner = gameService.winnerCalculator(gameParticipants);

    assertThat(winner).isEqualTo(new Winner("c", new Position(4)));
  }

  @Test
  @DisplayName("공동 우승자 테스트")
  void coWinnerTest() {
    List<Car> gameParticipants = Arrays.asList(
        new Car("a", new Position(3)),
        new Car("b", new Position(2)),
        new Car("c", new Position(1)),
        new Car("d", new Position(2)),
        new Car("e", new Position(3)));
    GameService gameService = new GameService();
    String coWinner = gameService.addWinner(gameParticipants);
    assertThat(coWinner).isEqualTo("a, e");
  }


}