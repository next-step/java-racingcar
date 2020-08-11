package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 Car에 대한 기능테스트")
public class CarTest {
    Car car;

    @ParameterizedTest
    @CsvSource(value = {"Lady,Lady", "Jamie,Jamie"})
    @DisplayName("생성자 통해 만든 Car 객체에 대해 초기 이름 조건 입력되는지 확인.")
    void create_Car_Domain_With_Name_Test(String name, String expected) {
        car = new Car(name);
        assertThat(car.getName()).isEqualTo(expected);
    }
}
