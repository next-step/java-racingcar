package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Car 테스트")
class CarTest {

    private final TryStrategy alwaysTrueStrategy = () -> true;
    private final TryStrategy alwaysFalseStrategy = () -> false;

    @Test
    void 전진하는_조건을_만족하는_경우_전진에_성공한_횟수가_1_증가() {
        Car car = new Car(alwaysTrueStrategy);

        car.tryOnce();

        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    void 전진하는_조건을_만족하지_않는_경우_전진에_성공한_횟수가_증가하지_않음() {
        Car car = new Car(alwaysFalseStrategy);

        car.tryOnce();

        assertThat(car.getMoveCount()).isZero();
    }

}