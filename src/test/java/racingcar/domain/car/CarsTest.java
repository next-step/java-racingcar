package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.domain.car.CarNameTest.VALID_CAR_NAME;
import static racingcar.domain.car.CarPosition.MOVABLE_DISTANCE;
import static racingcar.domain.car.CarTest.DEFAULT_CAR;
import static racingcar.domain.car.CarTest.WINNER_CAR;

@DisplayName("자동차 경주 - Cars 테스트")
class CarsTest {
    private final CarNames carNames = new CarNames(List.of(VALID_CAR_NAME));

    @Test
    void Cars는_car목록으로_생성이_가능하다() {
        assertThat(new Cars(List.of(DEFAULT_CAR, DEFAULT_CAR)))
                .isInstanceOf(Cars.class);
    }

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
        Cars cars = new Cars(List.of(DEFAULT_CAR, DEFAULT_CAR, DEFAULT_CAR, DEFAULT_CAR));

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
    void getWinnerCars는_승자_목록을_반환한다() {
        Cars cars = new Cars(List.of(WINNER_CAR, DEFAULT_CAR, WINNER_CAR, DEFAULT_CAR));

        List<Car> winners = cars.getWinnerCars();

        assertAll(
                () -> assertEquals(2, winners.size()),
                () -> assertEquals(WINNER_CAR.getName(), winners.get(0).getName()),
                () -> assertEquals(WINNER_CAR.getPosition(), winners.get(0).getPosition())
        );
    }
}
