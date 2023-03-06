package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class Car{
    private final String name;
    private static final int MAXIMUN_NAME_LENGTH = 5;
    public Car(final String name) {
        if(name.length()>MAXIMUN_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5글자 넘으면안됨");
        }
        this.name = name;

        }

    public String getName() {
        return name;
    }
}
public class CarTest {
    @DisplayName("자동차는 이름을 입력받아 갖는다.")
    @ValueSource(strings = {"jason", "joy"})
    @ParameterizedTest
    public void name(){
        final Car car = new Car("jason");
        assertThat(car.getName()).isEqualTo("jason");
    }

    @DisplayName("자동차 이름의 길이가 5글자 넘으면 예외발생한다.")
    @Test
    public void nameCheck(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("adfasdfasdf"));
    }

}


