package newcarracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private RacingGame racingGame = RacingGame.makeRacingGame(new RandomRuleCondition());
    private String[] carNames;

    @BeforeEach
    void 테스트_리소스_초기화() {
        carNames = "pobi,crong,honux".split(",");
    }

    @ParameterizedTest
    @CsvSource(value = {"0,pobi", "1,crong", "2,honux"}, delimiter = ',')
     void 자동차_경주_1회_시도_참여한_자동차_이름_확인(int index, String carName) throws CloneNotSupportedException {
        List<RacingCars> racingCars = racingGame.play(carNames, 1);
        assertThat(racingCars).hasSize(1);
        assertThat(racingCars.get(0).getRacingCars()).hasSize(3);
        assertThat(racingCars.get(0).getRacingCars().get(index).getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void 자동차_경주_우승자_확인(int tryCount) throws CloneNotSupportedException {
        List<RacingCars> racingCars = racingGame.play(carNames, tryCount);
        ResultView.printGameResult(racingCars);
    }
}