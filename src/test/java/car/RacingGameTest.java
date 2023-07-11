package car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.model.Car;
import car.model.Cars;
import car.model.RacingGame;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {

    @Test
    @DisplayName("시도 횟수가 양수여야지 게임 객체 생성 가능")
    void isLeftRound_확인_양수() {
        assertThatCode(() -> new RacingGame("jj, jjj", 1)
            .runRaceOnce())
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수가 음수이면, 게임 객체 생성 불가")
    void isLeftRound_확인_음수() {
        assertThrows(IllegalArgumentException.class, () -> new RacingGame("jj,jjj", -1));
    }


    @ParameterizedTest
    @DisplayName("이름 오류 나면 게임 객체 생성 불가")
    @ValueSource(strings = {"", " aaaaaa, aa"})
    void 이름_오류_확인(String carNames) {
        assertThatThrownBy(() -> new RacingGame(carNames, 1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("이름 정상이면 게임 객체 생성 가능")
    @ValueSource(strings = {"aa, ss", "aaaaa, aa"})
    void 이름_정상_동작_확인(String carNames) {
        Assertions.assertThatCode(() -> new RacingGame(carNames, 1))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("winner 찾기")
    void 우승자_찾는_메서드() {
        // given
        List<Car> cars = List.of(new Car("he1", 1),
            new Car("he2", 2),
            new Car("he3", 3));
        RacingGame racingGame = new RacingGame(new Cars(cars), 0);
        // when
        List<Car> winner = racingGame.selectWinner();
        // then
        assertThat(winner).extracting("name").contains("he3");
    }


    @Test
    @DisplayName("winner 복수 찾기")
    void 우승자_여러명_찾는_메서드() {
        // given
        List<Car> cars = List.of(new Car("he1", 1),
            new Car("he2", 3),
            new Car("he3", 3));
        RacingGame racingGame = new RacingGame(new Cars(cars), 0);
        // when
        List<Car> winner = racingGame.selectWinner();
        // then
        assertThat(winner).extracting("name").contains("he2", "he3");
    }

}
