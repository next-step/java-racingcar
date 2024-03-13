package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("자동차 경주 게임 초기화 테스트: 각 자동차의 이름 (n번 자동차) 와 초기 위치(0)을 가짐")
    public void createAttendedCars(int input) {
        Game game = new Game();
        game.createAttendedCars(3);
        assertThat(game.getAttendedCars().size()).isEqualTo(3);
        assertThat(game.getAttendedCars().get(input).getName()).isEqualTo(1 + input + "번 자동차");
        assertThat(game.getAttendedCars().get(input).getCurrentLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    @DisplayName("자동차 경주 게임 테스트: 5번을 실행했을 때, 각 자동차의 위치가 0과 5사이에 있음")
    public void playGame(int input) {
        Game game = new Game();
        game.createAttendedCars(5);
        game.playGame(5);
        assertThat(game.getAttendedCars().get(input).getCurrentLocation()).isBetween(0, 5);
    }
}