package game.race;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import game.race.support.CarRacingManager;
import game.race.view.InputView;

class CarRaceTest {

    Car car;
    InputView inputView;
    CarRacingManager manager;

    @BeforeEach
    void init() {
        inputView = new InputView();
        car = new Car();
        manager = new CarRacingManager();
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
}
