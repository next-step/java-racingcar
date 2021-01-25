package racingcar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("asCarsListTest: 이름을 통해 제대로 차량 리스트가 만들어지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"김보배,윤동희,김규민,제이슨,팀,짱짱짱짱,아자", "이즈리얼,코그모,이블린,피즈"})
    void asCarsListTest(String input) {
        List<Car> carList = Car.asCarsList(input);
        String[] expectedCarsName = input.split(",");
        for(int i =0; i < carList.size(); ++i){
            assertThat(carList.get(i).getName()).isEqualTo(expectedCarsName[i]);
        }
    }
}