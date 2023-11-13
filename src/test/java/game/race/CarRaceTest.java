package game.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import game.race.support.move.impl.RandomPolicy;
import game.race.view.InputView;

class CarRaceTest {

    static Car car;

    @BeforeAll
    static void init() {
        car = new Car("TEST");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈문자_또는_null_입력_되면_오류를_발생_시키는_테스트(String input) {
        assertThatThrownBy(() -> InputView.checkNames(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자_0_을_입력_되면_오류를_발생_시키는_테스트() {
       assertThatThrownBy(() -> InputView.checkTryCount("0")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"5, 1", "6, 2", "7, 3", "1, 3", "9, 4", "0, 4"})
    void 자동차_움직임_확인_하는_테스트(int randomNumber, int moveCount) {
        // given
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
}
