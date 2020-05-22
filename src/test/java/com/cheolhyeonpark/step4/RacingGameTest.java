package com.cheolhyeonpark.step4;

import com.cheolhyeonpark.step4.domain.Car;
import com.cheolhyeonpark.step4.domain.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.*;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"test1, -1", "test2, -2", "test3, -3"})
    @DisplayName("음수 입력시 예외 발생")
    public void throwExceptionWhenThereIsNegativeInput(String namesOfCars, int stageLeft) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGame(namesOfCars, stageLeft));
    }

    @Test
    @DisplayName("입렫받은 차의 대수 만큼 Car객체를 생성해야한다")
    public void getCars() {
        //given
        String namesOfCars = "testCar1,testCar2,testCar3";
        RacingGame racingGame = new RacingGame(namesOfCars, 0);

        //when
        List<Car> cars = racingGame.getResultOfStage();

        //then
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("스테이지 실행 확인")
    public void runStage() {
        //given
        String namesOfCars = "testCar1,testCar2,testCar3";
        RacingGame racingGame = spy(new RacingGame(namesOfCars, 5));

        //when
        racingGame.playStage();

        //then
        verify(racingGame, times(1)).playStage();
    }

    @Test
    @DisplayName("스테이지가 남아있는지 검사")
    public void checkStageLeft() {
        //given
        String namesOfCars = "testCar1,testCar2,testCar3";
        RacingGame racingGame = new RacingGame(namesOfCars, 1);
        boolean hasStageLeftBeforePlay = racingGame.hasNextStage();

        //when
        racingGame.playStage();
        boolean hasStageLeftAfterPlay = racingGame.hasNextStage();

        //then
        assertThat(hasStageLeftBeforePlay).isTrue();
        assertThat(hasStageLeftAfterPlay).isFalse();
    }

    @Test
    @DisplayName("게임이 끝난 뒤 우승자가 반환 되어야 한다")
    public void getWinners() {
        //given
        String namesOfCars = "testCar1,testCar2,testCar3";
        RacingGame racingGame = new RacingGame(namesOfCars, 1);

        //when
        racingGame.playStage();
        List<Car> winners = racingGame.getWinners();

        //then
        assertThat(winners.isEmpty()).isFalse();
    }
}