package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.factory.CarFactory;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동자 공장 테스트")
public class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("자동자 생성")
    public void create(int numberOfCars) {
        assertThat(CarFactory.create(numberOfCars)).hasSize(numberOfCars);
    }

}
