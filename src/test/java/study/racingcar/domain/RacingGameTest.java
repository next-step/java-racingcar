package study.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @DisplayName("자동차 이름 정상 입력")
    @ParameterizedTest(name="{displayName} | 요청값: {0} | 사실여부: {1}")
    @CsvSource(value = {"유재석,강호동:3", "지미유,조세호:5"}, delimiter = ':')
    void 자동차_이름_정상_입력(String carNames, int tryRound) {
        assertThat(new RacingGame(carNames, tryRound).equals(new RacingGame(carNames, tryRound))).isTrue();
    }

    @DisplayName("자동차 이름 비정상 입력 시, IllegalArgumentException 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0} | 사실여부: {1}")
    @CsvSource(value = {":3", " :5"}, delimiter = ':')
    void 자동차_이름_비정상_입력(String carNames, int tryRound) {
        assertThatThrownBy(() -> {
            new RacingGame(carNames, tryRound);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    class TestNest{
        RacingGame racingGame;
        private List<Car> carGroup;

        @BeforeEach
        void setUp() {
            carGroup = new ArrayList<>();
            carGroup.add(new Car(new Name("유재석"), new Position(2)));
            carGroup.add(new Car(new Name("강호동"), new Position(2)));

            racingGame = new RacingGame("유재석,강호동", 2);
            racingGame.playRound(() -> true);
            racingGame.playRound(() -> true);
        }

        @DisplayName("라운드 진행 후 차량 결과 비교")
        @Test
        void 라운드_진행_후_차량_결과 (){
            assertThat(racingGame.getResult()).isEqualTo(carGroup);
        }

        @DisplayName("라운드 진행 후 우승자 결과 비교")
        @Test
        void 라운드_진행_후_우승자_결과(){
            assertThat(racingGame.getWinners()).isEqualTo(carGroup);
        }

        @DisplayName("라운드 종료 후 라운드 여부 조회")
        @Test
        void 라운드_종료_후_라운드_여부 (){
            assertThat(racingGame.moreRound()).isEqualTo(false);
        }
    }
}
