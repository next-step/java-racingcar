package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private List<String> carNames;

    @BeforeEach
    void setUp() {
        //given
        carNames = Arrays.asList("정원", "자바", "레이서");
    }

    @DisplayName("게임에 참여할 자동차 이름들을 입력하면 자동차 컬렉션을 생성할 수 있다")
    @Test
    public void newCarsWithNumberOfCars() {
        //when
        Cars cars = new Cars(carNames);

        //then
        assertThat(cars).isNotNull();
    }

    @DisplayName("자동차 컬렉션은 포함하고 있는 모든 자동차를 전진시킬 수 있다")
    @Test
    public void makeAllCarsToMove() {
        //when
        Cars cars = new Cars(carNames);

        //then
        assertThat(cars.moveAllCar(() -> true)).isNotNull();
    }

    @DisplayName("각 자동차들의 포지션 상태를 비교해서 우승자를 정할 수 있다")
    @Test
    public void getWinnerTest() {
        //given
        Car car1 = new Car("정원").move(true).move(true).move(true);
        Car car2 = new Car("자바").move(true).move(false).move(false);
        Car car3 = new Car("레이싱").move(true).move(false).move(false);
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        //when
        List<String> winners = cars.getWinners();
        System.out.println(winners);

        //then
        assertThat(winners).containsExactly(car1.getName());
    }

    @DisplayName("우승자는 복수가 가능하다")
    @Test
    public void getWinnersTest() {
        //given
        Car car1 = new Car("정원").move(true).move(true).move(true);
        Car car2 = new Car("자바").move(true).move(false).move(false);
        Car car3 = new Car("레이싱").move(true).move(true).move(true);
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        //when
        List<String> winners = cars.getWinners();
        System.out.println(winners);

        //then
        assertThat(winners).containsExactly(car1.getName(), car3.getName());
    }
}
