package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @Test
    @DisplayName("차량 이름 목록을 등록하면 이름 개수 만큼 차량이 등록되어야 한다.")
    public void registerCarTest() {
        // given
        String[] names = {"Iron man", "Bat man", "Spider man"};
        int tryCount = 5;
        List<Car> cars = CarFactory.createCars(names);
        RacingGame racingGame = RacingGame.of(tryCount, cars);

        // then
        assertThat(racingGame.getEntryCars()).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 9})
    @DisplayName("경기 시작 시 tryCount 수 만큼 result 가 기록되어야 한다.")
    public void startRacingGameTest(int tryCount) {
        // given
        String[] names = {"Iron man", "Bat man", "Spider man"};
        List<Car> cars = CarFactory.createCars(names);
        RacingGame racingGame = RacingGame.of(tryCount, cars);

        // when
        racingGame.startGame();

        // then
        assertThat(racingGame.getResultRecorder().getResult()).hasSize(tryCount);
    }
    
    @Test
    @DisplayName("차량 등록 안하고 start 메소드 호출 시 예외발생")
    public void whenCallStartMethodWithoutRegisterCarThenException(){
        // given
        RacingGame racingGame = RacingGame.of(4, null);

        // then
        assertThatIllegalStateException().isThrownBy(
                racingGame::startGame
        );
    }

    @ParameterizedTest
    @DisplayName("이름이 공백인 경우 예외 발생")
    @ValueSource(strings = {"car1,car2, ", "  ,  , ", "", " "})
    public void invalidCarNamesTest(String input){
        // given
        String[] names = input.split(",");

        System.out.println(Arrays.toString(names));

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> CarFactory.createCars(names)
        );
    }
}