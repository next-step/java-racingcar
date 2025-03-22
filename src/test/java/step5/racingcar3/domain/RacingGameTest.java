package step5.racingcar3.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    @DisplayName("우승자가 한 명일 경우 우승자 찾기")
    void givenRacingGameEnd_whenFindWinners_thenWinnerRight() {
        // given
        CarEngine carEngineBroken1 = new CarEngine(CarEngine.ALWAYS_STOP_THRESHOLD);
        CarEngine carEngineBroken2 = new CarEngine(CarEngine.ALWAYS_STOP_THRESHOLD);
        CarEngine carEngineBroken3 = new CarEngine(CarEngine.ALWAYS_STOP_THRESHOLD);

        Car car1 = new Car(new CarName("a"), carEngineBroken1, new Position(1));
        Car car2 = new Car(new CarName("b"), carEngineBroken2, new Position(2));
        Car car3 = new Car(new CarName("c"), carEngineBroken3, new Position(3));
        PositiveNumber numberOfRounds = new PositiveNumber(PositiveNumber.MIN_VALUE);

        // when
        RacingGame racingGame = new RacingGame(new CarList(List.of(car1, car2, car3)), numberOfRounds);
        racingGame.start();
        racingGame.end();
        CarList winners = racingGame.winners();

        // then
        assertThat(winners.value()).isEqualTo(List.of(car3));
    }

    @Test
    @DisplayName("우승자가 여러명일 경우 우승자 찾기")
    void givenRacingGameEnd_whenFindWinners_thenWinnersRight() {
        // given
        CarEngine carEngineBroken1 = new CarEngine(CarEngine.ALWAYS_STOP_THRESHOLD);
        CarEngine carEngineBroken2 = new CarEngine(CarEngine.ALWAYS_STOP_THRESHOLD);
        CarEngine carEngineBroken3 = new CarEngine(CarEngine.ALWAYS_STOP_THRESHOLD);

        Car car1 = new Car(new CarName("a"), carEngineBroken1, new Position(3));
        Car car2 = new Car(new CarName("b"), carEngineBroken2, new Position(3));
        Car car3 = new Car(new CarName("c"), carEngineBroken3, new Position(3));
        PositiveNumber numberOfRounds = new PositiveNumber(PositiveNumber.MIN_VALUE);

        // when
        RacingGame racingGame = new RacingGame(new CarList(List.of(car1, car2, car3)), numberOfRounds);
        racingGame.start();
        racingGame.end();
        CarList winners = racingGame.winners();

        // then
        assertThat(winners.value()).isEqualTo(List.of(car1, car2, car3));
    }

}
