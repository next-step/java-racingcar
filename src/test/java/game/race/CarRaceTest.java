package game.race;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import game.race.view.InputView;
import game.race.dto.RaceDto;
import game.race.support.CarRacingManager;

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

    @ParameterizedTest
    @CsvSource({"3", "4","5"})
    void 자동차_수와_맞게_각_자동차_이동_결과를_반환_하는_테스트(int cars) {
        List<Car> carList = Car.getCars(cars);
        for (Car car : carList) {
            System.out.println("move count: " + car.getMoveCount());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "3, 5",
            "2, 4",
            "3, 3"
    })
    void 자동차_수와_시도_횟수에_맞게_타이어_자국_수를_확인_하는_테스트(int cars, int tryCnt) {
        CarRacingManager.start(RaceDto.of(cars, tryCnt));
    }
}
