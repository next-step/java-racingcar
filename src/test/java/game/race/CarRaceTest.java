package game.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import game.race.support.move.impl.RandomPolicy;
import game.race.view.InputView;

class CarRaceTest {

    static Car car;
    static InputView inputView;

    @BeforeAll
    static void init() {
        car = new Car("TEST");
        inputView = new InputView();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 숫자를_입력_하지_않으면_오류를_발생_시키는_테스트(String input) {
        assertThatThrownBy(() -> inputView.checkInput(input)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.checkInput("english")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.checkInput("korean")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자_0_을_입력하면_오류를_발생_시키는_테스트() {
        assertThatThrownBy(() -> inputView.checkInput("0")).isInstanceOf(IllegalArgumentException.class);
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
