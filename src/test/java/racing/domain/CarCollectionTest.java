package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.generator.SpecificNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarCollectionTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 10})
    void isMovableReturnFalseTest(int number) {
        //given
        CarCollection cars = new CarCollection(new ArrayList<>());

        //when, then
        assertThat(cars.isMovable(number)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isMovableReturnTrueTest(int number) {
        //given
        CarCollection cars = new CarCollection(new ArrayList<>());

        //when, then
        assertThat(cars.isMovable(number)).isEqualTo(true);
    }

    @Test
    void nextStateGoForwardTest() {
        //given
        CarCollection cars = new CarCollection(List.of(
                new Car(new Name("test1"), new Position(2)),
                new Car(new Name("test2"), new Position(4))));

        //when
        CarCollection carCollection = cars.nextState(new SpecificNumberGenerator(9));

        //then
        assertThat(carCollection).isEqualTo(new CarCollection(List.of(
                new Car(new Name("test1"), new Position(3)),
                new Car(new Name("test2"), new Position(5))
        )));
    }
}