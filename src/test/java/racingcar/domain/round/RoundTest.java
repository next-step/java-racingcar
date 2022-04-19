package racingcar.domain.round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 경주 - Round 테스트")
class RoundTest {
    private static final int WINNER_POSITION = 5;

    private Cars cars;
    private final List<Integer> carPositions = List.of(WINNER_POSITION, 1, 2, 4, WINNER_POSITION);

    @BeforeEach
    public void init() {
        cars = createMovableCars(carPositions);
    }

    private Cars createMovableCars(List<Integer> carPositions) {
        return new Cars(carPositions.stream().map(position -> new Car(Integer.toString(position), position, () -> true)).collect(Collectors.toList()));
    }

    @Test
    void play는_cars를_동작시킨다() {
        Round round = new Round(cars);

        assertThat(round.play().getCars().getCars().stream().map(Car::getPosition).collect(Collectors.toList()))
                .isEqualTo(carPositions.stream().map(position -> position + 1).collect(Collectors.toList()));
    }


    @Test
    void Round는_cars_없이_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Round(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getWinners는_승자_목록을_반환한다() {
        Round round = new Round(cars);

        List<Car> winners = round.getWinners();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo(Integer.toString(WINNER_POSITION));
        assertThat(winners.get(0).getPosition()).isEqualTo(WINNER_POSITION);
    }
}
