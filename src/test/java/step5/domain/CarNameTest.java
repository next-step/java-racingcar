package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Cars;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-11-14.
 */
public class CarNameTest {

    @ParameterizedTest
    @DisplayName("차 이름이 없을 때 IllegalArgumentException 예외를 던진다")
    @ValueSource(strings = {"", " ", "ab,,d"})
    public void isCarName_Empty_throw_IllegalArgument(String names) {
        assertThatThrownBy(() -> Cars.of(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주할 차 이름의 입력값이 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("차 이름이 5자 이내일 때는 정상이다")
    @ValueSource(strings = {"a,b,c,d", "abc,d", "abie,codec,f5"})
    public void isCarName_below_five_characters(String name) {
        Cars cars = Cars.of(name);
        String carNames = cars.getCars().stream()
                .map(car -> car.getName()).collect(Collectors.joining(","));

        assertThat(carNames).isEqualTo(name);
    }

    @ParameterizedTest
    @DisplayName("차 이름이 5자 초과일 때 IllegalArgumentException 예외를 던진다")
    @ValueSource(strings = {"abcf,abcdef", "a,b,1234567"})
    public void isCarName_over_five_characters_throw_Exception(String names) {
        assertThatThrownBy(() -> Cars.of(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5 자를 초과할 수 없습니다.");
    }

}
