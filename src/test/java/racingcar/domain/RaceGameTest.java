package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RaceGameTest {

    public static final List<String> WINNERS_NAME = List.of("pobi", "jason", "jobi");
    private static final List<Car> CARS = List.of(
            new Car("pobi"),
            new Car("jason"),
            new Car("jobi")
    );

    @DisplayName("유효한 값으로 RaceGame 인스턴스가 정상적으로 생성된다")
    @Test
    void create() {
        RaceGame raceGame = new RaceGame(CARS);
        assertThat(raceGame).isNotNull();
    }

    @DisplayName("moveCars를 했을 때, 현재 위치가 가장 먼 자동차의 이름을 우승자로 잘 반환하는지 검증")
    @Test
    void getWinners() {
        RaceGame raceGame = new RaceGame(CARS);
        raceGame.moveCars(() -> true);
        List<String> winnersName = raceGame.getWinnersName();

        assertThat(winnersName).isEqualTo(WINNERS_NAME);
    }
}