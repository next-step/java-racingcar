package racing.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private static final int MOVE_NUMBER = 4;
    public static final int INIT_POSITION = 1;

    @DisplayName("Cars 객체를 생성 할 수 있다.")
    @Test
    void createTest() {
        List<String> carNames = List.of("BMW");
        Cars cars = createCars(carNames);

        Car sut = new Car(new Name("BMW"), new Position(INIT_POSITION));

        assertAll(() -> assertThat(cars.getCarList()).hasSize(1),
                () -> assertThat(cars.getCarList().get(0)).isEqualTo(sut));
    }

    @DisplayName("모든 자동차 객체를 움직일 수 있다.")
    @Test
    void moveTest() {
        // given
        List<String> carNames = List.of("BMW", "AUDI");
        Cars cars = createCars(carNames);

        // when
        Cars sut = cars.move(new FakeMovingStrategy(MOVE_NUMBER));

        // then
        assertAll(() -> assertThat(sut.getCarList().get(0).getPosition()).isEqualTo(new Position(2)),
                () -> assertThat(sut.getCarList().get(1).getPosition()).isEqualTo(new Position(2))
        );
    }

    @DisplayName("일급 콜렉션의 모든 자동차를 가져올 수 있다.")
    @Test
    void getCarListTest() {
        // given
        List<String> carNames = List.of("BMW", "AUDI", "BENZ");
        Cars cars = createCars(carNames);

        // when
        List<Car> carList = cars.getCarList();

        // then
        assertThat(carList)
                .extracting("name", "position")
                .containsExactly(
                        tuple(new Name("BMW"), new Position(1)),
                        tuple(new Name("AUDI"), new Position(1)),
                        tuple(new Name("BENZ"), new Position(1))
                );
    }

    @DisplayName("가장 많이 이동한 자동차를 우승자로 선정한다.")
    @Test
    void findWinnersTest() {
        // given
        List<Car> carList
                = Arrays.asList(
                new Car(new Name("BMW"), new Position(1)),
                new Car(new Name("AUDI"), new Position(2)),
                new Car(new Name("BENZ"), new Position(3))
        );
        Cars cars = new Cars(carList);

        // when
        List<Car> winner = cars.findWinners();

        // then
        assertAll(() -> assertThat(winner).hasSize(1),
                () -> assertThat(winner).extracting("name", "position")
                        .containsExactly(tuple(new Name("BENZ"), new Position(3)))
        );
    }

    @DisplayName("우승자가 여러명 일 수 있다.")
    @Test
    void manyWinnerTest() {
        // given
        List<Car> carList
                = Arrays.asList(
                new Car(new Name("BMW"), new Position(1)),
                new Car(new Name("AUDI"), new Position(5)),
                new Car(new Name("BENZ"), new Position(5))
        );
        Cars cars = new Cars(carList);

        // when
        List<Car> winner = cars.findWinners();

        // then
        assertAll(() -> assertThat(winner).hasSize(2),
                () -> assertThat(winner).extracting("name", "position")
                        .containsExactly(tuple(new Name("AUDI"), new Position(5)),
                                tuple(new Name("BENZ"), new Position(5))));
    }

    private Cars createCars(List<String> carNames) {
        return Cars.create(carNames);
    }
}
