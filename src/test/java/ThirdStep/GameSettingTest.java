package ThirdStep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class GameSettingTest {

    private final static int CARCOUNT = 3;
    private final static int ATTEMPTS = 5;

    @BeforeEach
    void initInput() {
        InputStream settings = new ByteArrayInputStream(String.format("%d %d", CARCOUNT, ATTEMPTS).getBytes());
        System.setIn(settings);
    }

    @Test
    @DisplayName("게임에 참여할 자동차 수와 시도 회수를 입력받고 저장할 수 있다.")
    void 경기_셋팅_테스트() {
        GameSetting.setting();

        assertThat(GameSetting.getCarCount()).isEqualTo(3);
        assertThat(GameSetting.getAttempts()).isEqualTo(5);
    }
}
