package racing.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.fake.FakeNumberGenerator;

class CarsTest {
    private static final int MOVE_NUMBER = 4;
    private static final int STOP_NUMBER = 3;

    @DisplayName("Cars 객체를 생성 할 수 있다.")
    @Test
    void createTest() {
        List<String> carNames = List.of("BMW");
        Cars cars = createCars(carNames);

        assertAll(() -> assertThat(cars.getCars()).hasSize(1),
                () -> assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1));
    }

    @DisplayName("모든 자동차 객체를 움직일 수 있다.")
    @Test
    void movedAllTest() {
        // given
        List<String> carNames = List.of("BMW", "AUDI");
        Cars cars = createCars(carNames);

        // when
        Cars sut = cars.movedAll(new FakeNumberGenerator(MOVE_NUMBER));

        // then
        assertAll(() -> assertThat(sut.getCars().get(0).getPosition()).isEqualTo(2),
                () -> assertThat(sut.getCars().get(1).getPosition()).isEqualTo(2)
        );
    }

    @DisplayName("리스트 안의 모든 자동차의 정보를 가져올 수 있다.")
    @Test
    void getCarsTest() {
        // given
        List<String> carNames = List.of("BMW", "AUDI", "BENZ");
        Cars cars = createCars(carNames);

        // when
        List<Car> carList = cars.getCars();

        // then
        assertThat(carList)
                .extracting("name.title", "position")
                .containsExactly(
                        tuple("BMW", 1),
                        tuple("AUDI", 1),
                        tuple("BENZ", 1)
                );
    }

    @DisplayName("가장 많이 이동한 자동차를 우승자로 선정한다.")
    @Test
    void getWinnerTest() {
        // given
        List<Car> carList
                = Arrays.asList(
                new Car(new CarName("BMW"), 1),
                new Car(new CarName("AUDI"), 2),
                new Car(new CarName("BENZ"), 3)
        );
        Cars cars = new Cars(carList);

        // when
        List<Car> winner = cars.getWinner();

        // then
        assertAll(() -> assertThat(winner).hasSize(1),
                () -> assertThat(winner).extracting("name.title", "position")
                        .containsExactly(tuple("BENZ", 3))
        );
    }

    @DisplayName("우승자가 여러명 일 수 있다.")
    @Test
    void manyWinnerTest() {
        // given
        List<Car> carList
                = Arrays.asList(
                new Car(new CarName("BMW"), 1),
                new Car(new CarName("AUDI"), 5),
                new Car(new CarName("BENZ"), 5)
        );
        Cars cars = new Cars(carList);

        // when
        List<Car> winner = cars.getWinner();

        // then
        assertAll(() -> assertThat(winner).hasSize(2),
                () -> assertThat(winner).extracting("name.title", "position")
                        .containsExactly(tuple("AUDI", 5), tuple("BENZ", 5))
        );
    }

    private Cars createCars(List<String> carNames) {
        return Cars.create(carNames);
    }
}
