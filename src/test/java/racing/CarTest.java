package racing;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DisplayName("Car 클래스 테스트")
class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

}