import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("생성 오류 테스트 - 5글자 이상일 때")
    public void groupExceptionTest() {
        String name = "honux, pobi, brownn";
        assertThatThrownBy(
            () -> new Cars(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성 오류 테스트 - 빈 문자열일 때")
    public void groupExceptionTest2() {
        String none = "";
        assertThatThrownBy(
            () -> new Cars(none)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("단체 생성 테스트")
    public void groupGenerationTest() {
        String name = "honux, pobi, brown";
        Cars cars = new Cars(name);
        assertAll(
            () -> assertThat(cars.cars.get(0).compareTo(cars.cars.get(1))).isEqualTo(0),
            () -> assertThat(cars.cars.get(1).compareTo(cars.cars.get(2))).isEqualTo(0)
        );
    }

}
