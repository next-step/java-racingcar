package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    private Car car1;
    private Car car2;

    @BeforeEach
    public void beforeEach() {
        car1 = new Car("car1");
        car2 = new Car("car2");
    }

    @DisplayName("3단계 - 자동차 경주 - 레이싱 자동차 객체가 생성되는지 확인")
    @Test
    void create_racing_cars() {
        assertThat(RacingCars.create(Collections.singletonList(car1))).isNotNull();
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 자동차가 전진하는지 확인")
    @Test
    void go_racing_cars() {
        //given
        RacingCars racingCars = RacingCars.create(Arrays.asList(car1, car2));

        //when
        racingCars.moveCars(() -> true);

        //then
        assertThat(car1.getPosition()).isEqualTo(new Position(1));
        assertThat(car2.getPosition()).isEqualTo(new Position(1));
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 자동차가 정지하는지 확인")
    @Test
    void stop_racing_cars() {
        //given
        RacingCars racingCars = RacingCars.create(Arrays.asList(car1, car2));

        //when
        racingCars.moveCars(() -> false);

        //then
        assertThat(car1.getPosition()).isEqualTo(new Position(0));
        assertThat(car2.getPosition()).isEqualTo(new Position(0));
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 레이싱 자동차 컬렉션에서 가장 멀리 간 position 값 을 반환하는지 확인")
    @Test
    void get_farthest_position() {
        //given
        RacingCars racingCars = RacingCars.create(Arrays.asList(car1, car2, new Car("car3", 9)));

        //when
        Position farthestPosition = racingCars.getFarthestPosition();

        //then
        assertThat(farthestPosition).isEqualTo(new Position(9));
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 레이싱 자동차 컬렉션에서 우승한 자동차를 반환하는지 확인")
    @Test
    void get_winner_cars() {
        //given
        RacingCars racingCars = RacingCars.create(Arrays.asList(car1, car2, new Car("car3", 9)));

        //when
        List<Car> winnerCars = racingCars.winnerCars();

        //then
        assertThat(winnerCars).hasSize(1);
    }
}
