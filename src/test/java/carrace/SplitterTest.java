package carrace;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SplitterTest {
    Splitter splitter = new Splitter();

    @Test
    @DisplayName("입력받은 carNames -> cars로 변환 확인")
    void splitCarNames() {
        String carNames = "jess,test,kim";
        List<Car> cars = splitter.splitCarNames(carNames);

        assertThat(cars.get(0).getName()).isEqualTo("jess");
        assertThat(cars.get(1).getName()).isEqualTo("test");
        assertThat(cars.get(2).getName()).isEqualTo("kim");
    }

    @Test
    @DisplayName("MAX_LENGTH 초과의 carName 입력받았을 때 RunTimeException 발생")
    void runtimeExceptionTest() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    splitter.splitCarNames("apollo");
                }).withMessage("자동차 이름은 최대 5자까지 허용됩니다.");
    }
}