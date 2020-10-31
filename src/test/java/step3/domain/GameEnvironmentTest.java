package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;

@DisplayName("게임 환경 테스트")
public class GameEnvironmentTest {
    GameEnvironment gameEnvironment = new GameEnvironment();

    @DisplayName("시도 횟수가 0보다 작을 때")
    @Test
    public void invalidTryCount() {
        assertThatThrownBy(() -> {
            gameEnvironment.setTry(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid count");
    }

    @DisplayName("자동차 대수가 0보다 작을 때")
    @Test
    public void invalidCarCount() {
        assertThatThrownBy(() -> {
            gameEnvironment.setCar(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid count");
    }

    @DisplayName("입력한 자동차 대수만큼 자동차 리스트 생성")
    @Test
    public void getCars() {
        gameEnvironment.setCar(3);

        int carCount = gameEnvironment.getCars().size();

        assertThat(carCount).isEqualTo(3);
    }

    @DisplayName("입력한 시도횟수 전달")
    @Test
    public void getTryCount() {
        gameEnvironment.setTry(3);

        int tryCount = gameEnvironment.getTryCount();

        assertThat(tryCount).isEqualTo(3);
    }
}