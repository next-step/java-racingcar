package racingcar.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class CarTest {

    @BeforeAll
    static void initAll() {
        System.out.println("start Car test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("end Car test");
    }

    @DisplayName("asCarsTest: 이름을 통해 제대로 차량 리스트가 만들어지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"김보배,윤동희,김규민,제이슨,팀,짱짱짱짱,아자", "이즈리얼,코그모,이블린,피즈"})
    void asCarsTest(String input) {
        List<Car> cars = Car.asCars(input);
        String[] expectedCarsName = input.split(",");
        for(int i =0; i < cars.size(); ++i){
            assertThat(cars.get(i).getName()).isEqualTo(expectedCarsName[i]);
        }
    }

    @DisplayName("moveForwardTest: 차량 전진 확인")
    @Test
    void moveForwardTest() {
        Car car = new Car("차량A", 123);
        car.moveForward();
        assertThat(car.getDistance()).isEqualTo(124);
    }
}