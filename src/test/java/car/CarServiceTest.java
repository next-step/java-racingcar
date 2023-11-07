package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static car.CarService.generate;
import static org.assertj.core.api.Assertions.assertThat;

public class CarServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("car 생성 테스트")
    void 자동창_생성_크기(int number) {
        assertThat(generate(number)).hasSize(number);
    }


}
