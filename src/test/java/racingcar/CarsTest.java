package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class CarsTest {

    @DisplayName("우승자는 여러 명일 수 있다.")
    @Test
    void 우승자목록() {
        Car one = new Car(1, new LoadMovable(), new CarName("one"), 3);
        Car two = new Car(1, new LoadMovable(), new CarName("two"), 5);
        Car three = new Car(1, new LoadMovable(), new CarName("three"), 5);
        Cars racingCars = new Cars(Arrays.asList(one, two, three));
        assertThat(racingCars.findWinners()).containsExactly(two, three);
    }

}
