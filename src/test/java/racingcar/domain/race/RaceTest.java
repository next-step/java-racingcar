package racingcar.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.exception.InvalidUserInputException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {
    Cars cars = new Cars(Arrays.asList("pobi", "bass", "hj"));

    @Test
    @DisplayName("레이스 생성 테스트")
    void 레이스_생성_성공_테스트() {
        Race race = new Race(cars, 2);
        assertThat(race.getCars()).isEqualTo(cars);
        assertThat(race.getRacingTime()).isEqualTo(2);
    }

    @Test
    @DisplayName("게임 횟수 음수 입력 테스트")
    void 게임_횟수_음수_입력_실패_테스트() {
        assertThatThrownBy(() -> new Race(cars, -1))
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessage("1회 이상의 게임 횟수를 입력해야 시작 가능합니다.");
    }

    @Test
    @DisplayName("레이스 우승자 선정 테스트")
    void 레이스_우승자_선정_성공_테스트() {
        Race race = new Race(cars, 2);
        List<Car> carList = cars.getCars();
        Car pobi = carList.get(0);
        pobi.movePosition(4);
        pobi.movePosition(4);
        pobi.movePosition(4);
        pobi.movePosition(4);
        assertThat(race.getRaceWinners().size()).isEqualTo(1);
        assertThat(race.getRaceWinners().get(0)).isEqualTo(pobi);
    }
}
