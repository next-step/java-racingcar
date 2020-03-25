package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars cars;
    private String[] carNames = {"jihoon", "yeoseon"};

    @BeforeEach
    void setUp() {
        cars = new Cars(carNames);

        Car car1 = cars.getCar(0);
        Car car2 = cars.getCar(1);

        car1.move(1, true);
        car2.move(1, true);
        car1.move(2, true);
        car2.move(2, true);
        car1.move(3, true);
        car2.move(3, false);
    }

    @Test
    @DisplayName("Cars 인스턴스 생성 테스트")
    void newCars() {
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("입력받은 Car 이름의 개수만큼 Car length를 갖는다.")
    void getCarsLength() {
        assertThat(cars.getCarsLength()).isEqualTo(2);
    }

    @Test
    @DisplayName("인덱스를 통해 특정 Car의 정보에 접근할 수 있다.")
    void getCar() {
        assertThat(cars.getCar(0).getCarName()).isEqualTo("jihoon");
    }

    @Test
    @DisplayName("게임동안 Car들이 전진한 수만큼의 position을 가져올 수 있다.")
    void getFinalPosition() {
        assertThat(cars.getFinalPositionList()).containsExactly(3, 2);
    }
    
    @Test
    @DisplayName("입력받은 숫자 List 중 최대 숫자를 잘 고르는 지 테스트")
    void getMaxPosition() {
        List numberList = Arrays.asList(3, 4, 9);

        assertThat(cars.getMaxPosition(numberList)).isEqualTo(9);
    }

    @Test
    @DisplayName("Position이 가장 높은 Car의 이름을 승자로 받는다.")
    void getWinnerNames() {
        assertThat(cars.getWinnerNames()).containsExactly("jihoon");
    }
}
