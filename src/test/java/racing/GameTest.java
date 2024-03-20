package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Game;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("자동차 경주 게임 초기화 테스트: 입력한 String에 , 로 구분된 갯수만큼 자동차를 생성 & 초기 위치(0)을 가짐")
    public void createAttendedCars(int input) {
        Game game = new Game("전공,지식,노트");
        assertThat(game.getAttendedCars().size()).isEqualTo(3);
        assertThat(game.getAttendedCars().get(input).getCurrentLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름을 입력하여 자동차를 생성")
    public void enterCarNameToCreateCars() {
        Game game = new Game("전공,지식,노트");

        assertThat(game.getAttendedCars().size()).isEqualTo(3);
    }
}