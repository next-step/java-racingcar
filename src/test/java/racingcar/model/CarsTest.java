package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MovingGenerator;
import racingcar.util.NoMovingGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    @Test
    @DisplayName("문자열의 쉼표(,)를 구분자로 하여 자동차 생성")
    void createOfString() {
        String nameText = "test1, test2, test3";
        Cars cars = Cars.from(nameText);

        assertThat(cars.getCars())
                .hasSize(3)
                .extracting(Car::getName).containsExactly("test1", "test2","test3");
    }

    @Test
    @DisplayName("잘못된 문자열 입력으로 실패")
    void createOfStringFail() {
        String nameText = "test|test2$test3";
        assertThatIllegalArgumentException().isThrownBy(() -> Cars.from(nameText));
    }

    @Test
    @DisplayName("개수만큼 자동차를 생성한다")
    void createOfCount() {
        int count = 3;

        Cars generate = Cars.newInstance(count);

        assertThat(generate).isNotNull();
        assertThat(generate.getCars().size()).isEqualTo(3);
    }

    @DisplayName("자동차 생성 개수가 음수일 경우 실패")
    @Test
    void generateFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.newInstance(-1));
    }

    @Test
    @DisplayName("자동차들이 전진한다")
    void moveCar() {
        Cars cars = Cars.newInstance(3);
        cars.moveAll(new MovingGenerator());
        assertThat(cars.getCars()).extracting(Car::getPosition).containsOnly(2);
    }

    @Test
    @DisplayName("자동차는 움직이지 않는다")
    void nonMoveCar() {
        Cars cars = Cars.newInstance(3);
        cars.moveAll(new NoMovingGenerator());
        assertThat(cars.getCars()).extracting(Car::getPosition).containsOnly(1);
    }
}
