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
        car1 = new Car("car2");
        car2 = new Car("car2");
    }

    @DisplayName("3단계 - 자동차 경주 - 레이싱 자동차 객체가 생성되는지 확인")
    @Test
    void create_racing_cars() {
        assertThat(RacingCars.create(Collections.singletonList(car1))).isNotNull();
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 레이싱 자동차 컬렉션에서 가장 멀리 간 position 값 을 반환하는지 확인")
    @Test
    void get_farthest_position() {
        //given
        car1.go();
        RacingCars racingCars = RacingCars.create(Arrays.asList(car1, car2));

        //when
        int farthestPosition = racingCars.getFarthestPosition();

        //then
        assertThat(farthestPosition).isEqualTo(1);
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 레이싱 자동차 컬렉션에서 우승한 자동차를 반환하는지 확인")
    @Test
    void get_winner_cars() {
        //given
        car1.go();
        RacingCars racingCars = RacingCars.create(Arrays.asList(car1, car2));

        //when
        List<Car> winnerCars = racingCars.getWinnerCars();

        //then
        assertThat(winnerCars).hasSize(1);
    }
}
