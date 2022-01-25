package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IOclassTest {

    @DisplayName("자동차 이름이 5자를 초과하는 경우")
    @Test
    public void exceedFiveCharacter() {
        Car[] cars = new Car[3];
        cars[0]=new Car("one");
        cars[1]=new Car("two");
        cars[2]=new Car("threee");
        boolean flag = IOClass.checkCarName(cars);
        assertThat(flag).isEqualTo(false);
    }

    @DisplayName("자동차 이름은 5자를 초과하지 않는 경우")
    @Test
    public void belowFiveCharacter() {
        Car[] cars = new Car[3];
        cars[0]=new Car("one");
        cars[1]=new Car("two");
        cars[2]=new Car("three");
        boolean flag = IOClass.checkCarName(cars);
        assertThat(flag).isEqualTo(true);
    }
}