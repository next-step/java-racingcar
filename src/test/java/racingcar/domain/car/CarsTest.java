package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.car.CarNameTest.VALID_CAR_NAME;

@DisplayName("자동차 경주 - Cars 테스트")
class CarsTest {
    private static final String WINNER_NAME = "win";
    private static final String LOSER_NAME = "lose";
    private static final int WINNER_POSITION = 10;

    private final CarPosition winnerPosition = new CarPosition(WINNER_POSITION);
    private final CarPosition defaultPosition = CarPosition.createDefault();
    private final Car winner = new Car(new CarName(WINNER_NAME), winnerPosition, () -> true);
    private final Car defaultCar = new Car(new CarName(LOSER_NAME), defaultPosition, () -> true);

    private final CarNames carNames = new CarNames(List.of(new CarName(VALID_CAR_NAME)));

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
                        .map(car -> car.getPosition().increase())
                        .collect(Collectors.toList()));
    }

    @Test
    void getWinners는_승자_목록을_반환한다() {
        Cars cars = new Cars(List.of(winner, defaultCar, winner, defaultCar));

        List<Car> winners = cars.getWinnerCars();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo(winner.getName());
        assertThat(winners.get(0).getPosition()).isEqualTo(winner.getPosition());
    }
}
