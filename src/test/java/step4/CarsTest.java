package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Cars 테스트")
class CarsTest {

    private Cars cars = new Cars(new ArrayList<Car>(Arrays.asList(new Car("c1"), new Car("c2"))));

    @DisplayName("Cars 인스턴스 확인")
    @Test
    void getCars() {
        assertThat(cars.getCars().get(0)).isInstanceOf(Car.class);
    }

    @DisplayName("Cars 사이즈 확인")
    @Test
    void carsSize() {
        assertThat(cars.getCars().size()).isEqualTo(2);
    }

    @DisplayName("우승자 계산")
    @Test
    void calcWinner() {
        cars.getCars().get(0).move();
        List<String> winnerNames = cars.getWinnerNames();
        assertThat(winnerNames.get(0)).isEqualTo("c1");
    }
}
