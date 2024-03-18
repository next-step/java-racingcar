package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("자동차 경주 게임 초기화 테스트: 입력한 String에 , 로 구분된 갯수만큼 자동차를 생성 & 초기 위치(0)을 가짐")
    public void createAttendedCars(int input) {
        Game game = new Game();
        game.createAttendedCarsWithName("전공,지식,노트");
        assertThat(game.getAttendedCars().size()).isEqualTo(3);
        assertThat(game.getAttendedCars().get(input).getCurrentLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("자동차 경주 게임 테스트: 5번을 실행했을 때, 각 자동차의 위치가 0과 5사이에 있음")
    public void playGame(int input) {
        Game game = new Game();
        game.createAttendedCarsWithName("전공,지식,노트");
        game.playGame(5);
        assertThat(game.getAttendedCars().get(input).getCurrentLocation()).isBetween(0, 5);
    }

    @Test
    @DisplayName("시도 횟수에 음수 입력했을 경우, IllegalArgumentException 발생")
    public void negativeNumberInAttempts() {
        Game game = new Game();

        assertThatThrownBy(() -> {
            game.playGame(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("이름을 입력하여 자동차를 생성")
    public void enterCarNameToCreateCars() {
        Game game = new Game();

        game.createAttendedCarsWithName("전공,지식,노트");

        assertThat(game.getAttendedCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("게임에 참가한 자동차에서 가장 먼 거리를 간 자동차들을 반환")
    public void getWinners() {
        Car pobi = new Car("pobi", 4);
        Car jason = new Car("jason", 2);
        Car woni = new Car("woni", 4);
        List<Car> cars = Arrays.asList(pobi, jason, woni);

        Game game = new Game(cars);

        List<Car> winners = game.getWinners();

        assertThat(winners).contains(pobi, woni);
    }
}