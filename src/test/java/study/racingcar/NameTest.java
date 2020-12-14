package study.racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("Name 클래스의 name 성공 테스트")
    void name_test() throws Exception {
        String inputName = "truly";

        Car car = new Car(inputName);
        Name name = car.getName();

        assertThat(name).isEqualTo(new Name("truly"));
    }

    @Test
    @DisplayName("Name 클래스의 name 예외처리 테스트")
    void name_exception_test() throws Exception {
        String inputName = "sparkle";
        assertThatThrownBy(() -> {
            Car car = new Car(inputName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
