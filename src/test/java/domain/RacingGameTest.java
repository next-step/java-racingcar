package domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingGameTest {

    public static final int TEST_ROUND_COUNT = 3;

    @Test
    void 이름_문자열을_통해_Cars를_초기화할_수_있다() {
        RacingGame racingGame = new RacingGame("박찬우,박찬종,아이시스", TEST_ROUND_COUNT);

        assertThat(racingGame.getRacingCars().getCars().size()).isEqualTo(TEST_ROUND_COUNT);
    }

    @Test
    void race는_round가_감소된다() {
        RacingGame racingGame = new RacingGame("박찬우,박찬종,아이시스", TEST_ROUND_COUNT);
        racingGame.race();

        assertThat(racingGame.getRound()).isEqualTo(TEST_ROUND_COUNT - 1);
    }

    @Test
    void 모든_race_종료후_isEnd가_참이다() {
        RacingGame racingGame = new RacingGame("박찬우,박찬종,아이시스", 3);
        for (int i = 0; i < TEST_ROUND_COUNT; i++) {
            racingGame.race();
        }

        assertThat(racingGame.isEnd()).isTrue();
    }
}
