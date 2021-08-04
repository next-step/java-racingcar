package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceTest {

    private final CarRace carRace = new CarRace();

    @ParameterizedTest
    @ValueSource(strings = {"5", "!"})
    @DisplayName("게임프로필 테스트")
    void setGameProfileTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        carRace.setGameProfile();
        assertThat(carRace.getCarCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("랜덤숫자 테스트")
    void getRandomNumTest() {
        assertThat(RandomNum.getRandomNum()).isLessThanOrEqualTo(0);
    }

    @Test
    @DisplayName("자동차 경주 테스트")
    void playGameTest() {
        carRace.initGame();
    }

    @Test
    @DisplayName("메세지 테스트")
    void messageTest() {
        Message.askCarCount();
        Message.askGameCount();
    }


}