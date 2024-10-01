package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.random.RacingGameRandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private List<RacingCar> racingCars;

    @BeforeEach
    void setUp() {
        racingCars = List.of(
            new RacingCar(new RacingGameRandomNumberGenerator()),
            new RacingCar(new RacingGameRandomNumberGenerator()),
            new RacingCar(new RacingGameRandomNumberGenerator())
        );
    }

    @ParameterizedTest
    @CsvSource(value = { "1,1", "2,2", "9,9" })
    @DisplayName("라운드 수 만큼의 레이싱 결과 목록을 반환한다.")
    void testResultList(final int round, final int except) {
        final RacingGame racingGame = new RacingGame(racingCars, round);
        assertThat(racingGame.play()).hasSize(except);
    }
}