package racing.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racing.domain.NamedCars;

class DistanceWinnerStrategyTest {

  @RepeatedTest(100)
  @DisplayName("자동차들 중 제일 멀리 이동한 자동차가 선정되는지 확인")
  void winnerTest() {
    //given
    NamedCars winCars = NamedCars.newInstance("win1,win2", new NameLengthValidationStrategy(),
        new MustMoveStrategy());
    NamedCars loseCars = NamedCars.newInstance("lose1,lose2,lose3",
        new NameLengthValidationStrategy(), new MustMoveStrategy());
    Random random = new Random();
    DistanceWinnerStrategy distanceWinnerStrategy = new DistanceWinnerStrategy();
    int winAttempt = 100;
    for (int i = 0; i < winAttempt; i++) {
      winCars.attempt();
    }
    for (int i = 0; i < random.nextInt(winAttempt); i++) {
      loseCars.attempt();
    }

    //when
    NamedCars winners = distanceWinnerStrategy.getWinners(
        new NamedCars(
            Stream.concat(winCars.getNamedCars().stream(), loseCars.getNamedCars().stream())
                .collect(Collectors.toList())));

    //then
    assertThat(winCars.getNamedCars()).containsExactlyElementsOf(winners.getNamedCars());

  }

}