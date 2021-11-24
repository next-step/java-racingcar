package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.LoadMovable;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class CarsTest {

    @DisplayName("우승자는 여러 명일 수 있다.")
    @Test
    void 우승자목록() {
        Car one = new Car(1, new LoadMovable(), new CarName("one"), 3);
        Car two = new Car(2, new LoadMovable(), new CarName("two"), 5);
        Car three = new Car(3, new LoadMovable(), new CarName("three"), 5);
        Cars racingCars = new Cars(Arrays.asList(one, two, three));
        assertThat(racingCars.findWinners()).containsExactly(two, three);
    }

    @DisplayName("우승자의 이름을 문자열로 반환한다.")
    @Test
    void 우승자목록문자열() {
        Car one = new Car(1, new LoadMovable(), new CarName("one"), 3);
        Car two = new Car(2, new LoadMovable(), new CarName("two"), 5);
        Car three = new Car(3, new LoadMovable(), new CarName("three"), 5);
        Car four = new Car(4, new LoadMovable(), new CarName("four"), 5);
        Cars racingCars = new Cars(Arrays.asList(one, two, three, four));
        assertThat(racingCars.findWinnersString()).isEqualTo("two, three, four");

    }

}
