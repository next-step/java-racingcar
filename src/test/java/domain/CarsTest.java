package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("자동차들을 이동 후 우승자를 구할 수 있다.")
    @TestFactory
    Collection<DynamicTest> test01() {
        // given
        Cars cars = getTestFixture();

        return List.of(
                DynamicTest.dynamicTest("자동차들을 이동시킬 수 있다.", () -> {
                    // when
                    cars.move();

                    // then
                    assertThat(cars).isEqualTo(
                            new Cars(List.of(
                                    new Car("forbi", 1, () -> true),
                                    new Car("john", 0, () -> false),
                                    new Car("ahn", 1, () -> true)
                            ))
                    );
                }),
                DynamicTest.dynamicTest("우승자를 구할 수 있다.", () -> {
                    // when
                    Cars winners = cars.winners();

                    // then
                    assertThat(winners).hasSize(2)
                            .containsExactlyInAnyOrder(new Car("forbi", 1, () -> true), new Car("ahn", 1, () -> true));
                })
        );
    }

    private Cars getTestFixture() {
        Car car1 = new Car(new Name("forbi"), () -> true);
        Car car2 = new Car(new Name("john"), () -> false);
        Car car3 = new Car(new Name("ahn"), () -> true);
        return new Cars(List.of(car1, car2, car3));
    }
}
