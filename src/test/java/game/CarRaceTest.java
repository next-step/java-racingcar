package game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import game.race.Car;
import game.race.Race;
import game.race.model.InputView;
import game.race.model.ResultView;

class CarRaceTest {

    InputView inputView;
    ResultView resultView;
    Car car;

    @BeforeEach
    void init() {
        inputView = new InputView();
        resultView = new ResultView();
        car = new Car();
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
    @CsvSource({
            "1, 2, 2",
            "1, 3, 3",
            "5, 3, 15"
    })
    void 자동차_수와_시도_횟수에_맞게_경주_결과_수를_반환_하는_테스트(int tryCnt, int cars, int tireMarks) {
        Race race = new Race(tryCnt, cars);
        race.start();

        assertThat(race.getTireMarks().size()).isEqualTo(tireMarks);
    }
}
