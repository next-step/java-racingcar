package racingcar.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racing.util.RandomGenerator;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    @DisplayName("초기 세팅 테스트")
    @Test
    public void createGame() {
        RacingCarGame racingCarGame = new RacingCarGame(List.of("name1", "name2", "name3", "name4", "name5"));

        assertThat(racingCarGame.getCars().size())
                .isEqualTo(5);

        assertThat(racingCarGame.getStage())
                .isEqualTo(0);
    }

    @DisplayName("playAndResult 테스트1")
    @Test
    public void playAndResultGame() {
        RacingCarGame racingCarGame = new RacingCarGame(List.of("name1", "name2", "name3", "name4", "name5"), new mockRandomGenerator());

        racingCarGame.playAndWinners(10);

        // 한번 진행할 때마다 0,1,2,3,4 / 5,6,7,8,9 랜덤 값이 생성되어 마지막 인덱스의 자동차만 10이고 나머지는 5
        assertThat(racingCarGame.getCars().subList(0, 4))
                .allMatch(car -> car.getPosition() == 5);
        assertThat(racingCarGame.getCars().get(4).getPosition())
                .isEqualTo(10);

        assertThat(racingCarGame.getStage())
                .isEqualTo(10);

        assertThat(racingCarGame.getCurrentStageWinner())
                .containsExactly("name5");
    }

    @DisplayName("playAndResult 테스트2")
    @Test
    public void playAndResultGame2() {
        RacingCarGame racingCarGame = new RacingCarGame(List.of("name1", "name2", "name3"), new mockRandomGenerator());

        racingCarGame.playAndWinners(6);

        // 한번 진행할 때마다 0,1,2 / 3,4,5 / 6,7,8 / 9,0,1 / 2,3,4 / 5,6,7 랜덤 값이 생성되어 자동차 각각 3, 3, 4 포지션
        assertThat(racingCarGame.getCars().get(0).getPosition())
                .isEqualTo(3);
        assertThat(racingCarGame.getCars().get(1).getPosition())
                .isEqualTo(3);
        assertThat(racingCarGame.getCars().get(2).getPosition())
                .isEqualTo(4);

        assertThat(racingCarGame.getStage())
                .isEqualTo(6);

        assertThat(racingCarGame.getCurrentStageWinner())
                .containsExactly("name3");
    }

    @DisplayName("playAndResult 테스트3")
    @Test
    public void playAndResultGame3() {
        RacingCarGame racingCarGame = new RacingCarGame(List.of("name0", "name1", "name2", "name3", "name4", "name5", "name6", "name7", "name8", "name9"), new mockRandomGenerator());

        racingCarGame.playAndWinners(3);

        // 한번 진행할 때마다 name5 ~ name10이 한번씩 이동하여 공동 우승
        assertThat(racingCarGame.getCars().subList(0, 4))
                .allMatch(car -> car.getPosition() == 0);
        assertThat(racingCarGame.getCars().subList(5, 10))
                .allMatch(car -> car.getPosition() == 3);

        assertThat(racingCarGame.getCurrentStageWinner())
                .containsExactly("name4", "name5", "name6", "name7", "name8", "name9");
    }

    public static class mockRandomGenerator extends RandomGenerator {
        private final AtomicInteger number = new AtomicInteger(0);

        @Override
        public int generateRandomNumber(int max) {
            return number.getAndIncrement() % max;
        }
    }
}