package racinggame.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.car.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarsTest {

    @DisplayName("우승자 찾기 테스트")
    @Test
    public void findWinner_success() throws Exception {
        //given
        List<Car> cars = Arrays.asList(new Car("a", 1)
                , new Car("b", 2)
                , new Car("c", 3)
                , new Car("d", 4)
                , new Car("e", 4));
        RacingCars racingCars = new RacingCars(cars);

        //when
        List<String> winner = racingCars.findWinner();

        //then
        assertAll(
                () -> assertThat(winner.size()).isEqualTo(2),
                () -> assertThat(winner).isEqualTo(Arrays.asList("d", "e"))
        );
    }

    @DisplayName("RacingCars의 정적 팩토리 메서드의 동작을 확인한다.")
    @Test
    public void newRacingCarsFrom_success_factoryMethod() throws Exception {
        //given
        RacingCars racingCars = RacingCars.newRacingCarsFrom(Arrays.asList("a", "b", "c"));

        //then
        assertThat(racingCars.getCars().size()).isEqualTo(3);
    }
}
