package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @DisplayName("자동차 우승자 1명 확정 테스트")
    @Test
    void 자동차_우승자_1명_선정_테스트() {
        //given
        Car car1 = new Car("A", 3);
        Car car2 = new Car("B", 2);
        Car car3 = new Car("C", 5);
        Winner cars = new Winner(List.of(car1, car2, car3));

        //when
        List<String> winners = cars.getWinners();

        //then
        assertThat(String.join(",",winners)).isEqualTo("C");
    }

    @DisplayName("자동차경주 참여자 전체가 우승자가 된 경우 테스트")
    @Test
    void 자동차_우승자_모두_선정_테스트() {
        //given
        Car car1 = new Car("A", 5);
        Car car2 = new Car("B", 5);
        Car car3 = new Car("C", 5);
        Winner cars = new Winner(List.of(car1, car2, car3));

        //when
        List<String> winners = cars.getWinners();

        //then
        assertThat(String.join(",",winners)).isEqualTo("A,B,C");
    }

    @DisplayName("자동차경주 우승자가 없는 테스트")
    @Test
    void 자동차_우승자가_없는_테스트() {
        //given
        Car car1 = new Car("A", 0);
        Car car2 = new Car("B", 0);
        Car car3 = new Car("C", 0);
        Winner cars = new Winner(List.of(car1, car2, car3));

        //when
        List<String> winners = cars.getWinners();

        //then
        assertThat(winners).isEmpty();
    }
}
