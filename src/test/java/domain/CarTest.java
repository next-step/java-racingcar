package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car myCar;

    @BeforeEach
    public void setup() {
        myCar = new Car("myCar");
    }

    @DisplayName("4미만의 숫자를 입력 받았을 때는 전진하지 않음")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    public void getSmallerThanFourCarDoesNotMoveTest(int condition) {
        myCar.move(condition);
        // Then
        assertThat(myCar).isEqualTo(new Car("myCar", 1));
    }

    @DisplayName("4이상의 숫자를 입력 받았을 때는 전진하지 않음")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9})
    public void getGreaterThanFourCarMoveTest(int condition) {
        myCar.move(condition);
        // Then
        assertThat(myCar).isEqualTo(new Car("myCar", 2));
    }


}
