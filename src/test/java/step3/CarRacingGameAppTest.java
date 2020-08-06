package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.app.CarRacingGameApp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("자동차 경주 게임 앱 테스트")
public class CarRacingGameAppTest {

    @ParameterizedTest
    @CsvSource(value = {"jylee,e20uk,dlwndud:3"}, delimiter = ':')
    @DisplayName("인풋 값 벨리데이션 테스트")
    public void splitAndValidateCsvNameLineOfCars(String csvNameLineOfCars, int length) {
        assertThat(CarRacingGameApp.splitAndValidateCsvNameLineOfCars(csvNameLineOfCars).length).isEqualTo(length);
    }

    @ParameterizedTest
    @ValueSource(strings = {"jylee,e200uk,dlwndud"})
    @DisplayName("인풋 값 벨리데이션 예외 발생 테스트")
    public void splitAndValidateCsvNameLineOfCarsThrowException(String csvNameLineOfCars) {
        assertThatIllegalArgumentException().isThrownBy(() -> CarRacingGameApp.splitAndValidateCsvNameLineOfCars(csvNameLineOfCars));
    }

}
