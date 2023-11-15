package game.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import game.race.domain.Car;
import game.race.domain.support.Cars;
import game.race.domain.support.move.MovePolicy;
import game.race.domain.support.move.impl.RandomPolicy;
import game.race.util.Validator;
import game.race.view.InputView;

class CarRaceTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈문자_또는_null_입력_되면_오류를_발생_시키는_테스트(String input) {
        assertThatThrownBy(() -> InputView.getNames(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자_0_을_입력_되면_오류를_발생_시키는_테스트() {
       assertThatThrownBy(() -> Validator.checkTryCount("0")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 하나라도_이름의_길이가_다섯자를_초과하면_실패하는_테스트() {
        List<String> list = Arrays.asList("abc", "abcdef", "abcc");
        assertThatThrownBy(() -> Validator.checkNames(list)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"5, 1", "6, 2", "7, 3", "1, 3", "9, 4", "0, 4"})
    void 자동차_움직임_확인_하는_테스트(int randomNumber, int moveCount) {
        // given
        Car car = new Car("TEST");
        RandomPolicy randomPolicy = new RandomPolicy() {
            @Override
            public int getPolicyNumber() {
                return randomNumber;
            }
        };

        // when
        car.move(randomPolicy);

        // then
        assertThat(car.getMoveCount()).isEqualTo(moveCount);
    }

    @Test
    void 자동차_우승자를_확인하는_테스트() {
        // given
        List<String> list = Arrays.asList("abc", "abcd", "abcdef");
        Cars cars = Cars.of(list);
        MovePolicy forward = () -> true;
        MovePolicy stop = () -> false;

        // when
        cars.getCars().get(0).move(forward);
        cars.getCars().get(1).move(stop);
        cars.getCars().get(2).move(stop);

        // then
        assertThat(cars.getWinners().size()).isEqualTo(1);
        assertThat(cars.getWinners().get(0)).isEqualTo("abc");
    }
}
