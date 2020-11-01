package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DisplayName("게임 환경 테스트")
public class GameEnvironmentTest {
    GameEnvironment gameEnvironment;

    @DisplayName("입력한 자동차 대수만큼 자동차 리스트 생성")
    @Test
    public void getCars() {
        gameEnvironment = new GameEnvironment(3, 1);

        int carCount = gameEnvironment.getCars().size();

        assertThat(carCount).isEqualTo(3);
    }

    @DisplayName("입력한 시도횟수 전달")
    @Test
    public void getTryCount() {
        gameEnvironment = new GameEnvironment(3, 3);

        int tryCount = gameEnvironment.getTryCount();

        assertThat(tryCount).isEqualTo(3);
    }
}