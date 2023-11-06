package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
    private RacingCarGame racingCar = new RacingCarGame();
    @ParameterizedTest
    @ValueSource(ints = {-100,-5,0})
    @DisplayName("자동차 대수에 0보다 작은 값을 입력할 경우 에러 발생 ")
    void carCountInputError(int input){
        assertThatThrownBy(() -> {
            racingCar.play(input,3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-100,-5,0})
    @DisplayName("게임 횟수에 0보다 작은 값을 입력할 경우 에러 발생 ")
    void gameCountInputError(int input){
        assertThatThrownBy(() -> {
            racingCar.play(3, input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,13,77})
    @DisplayName("참여한 자동차의 개수는 입력된 자동차의 개수와 같아야한다.")
    void ActualCarCount(int carCount){
        assertThat(racingCar.play(carCount, 20).size()).isEqualTo(carCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,13,77})
    @DisplayName("최대로 전진한 자동차의 거리는 0이상 입력된 게임횟수 이하여야한다.")
    void ActualMaxDistance(int gameCount){
        int result = racingCar.play(3, gameCount).stream().mapToInt(String::length).max()
                .orElseThrow(NoSuchElementException::new);
        assertThat(result).isGreaterThanOrEqualTo(0);
        assertThat(result).isLessThanOrEqualTo(gameCount);
    }

}
