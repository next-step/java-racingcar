package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.car.CarNameTest.validCarName;
import static racingcar.domain.car.CarTest.*;

@DisplayName("자동차 경주 - Cars 테스트")
class CarsTest {
    private final CarNames carNames = new CarNames(List.of(validCarName));

    @Test
    void Cars는_빈_컬렉션으로_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Cars(Collections.emptyList());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Cars는_이동_전략_없이_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Cars(carNames, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void act는_자동차_전체를_동작시킨다() {
        Cars cars = new Cars(List.of(defaultCar, defaultCar, defaultCar, defaultCar));

        assertThat(cars.act()
                .getCars()
                .stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()))
                .isEqualTo(cars.getCars()
                        .stream()
                        .map(car -> car.getPosition() + MOVABLE_DISTANCE)
                        .collect(Collectors.toList()));
    }

    @Test
    void getWinners는_승자_목록을_반환한다() {
        Cars cars = new Cars(List.of(winnerCar, defaultCar, winnerCar, defaultCar));

        List<Car> winners = cars.getWinnerCars();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo(winnerCar.getName());
        assertThat(winners.get(0).getPosition()).isEqualTo(winnerCar.getPosition());
    }
}
