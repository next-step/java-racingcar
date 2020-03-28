package step4.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.racing.domain.Car;
import step4.racing.domain.RacingGame;
import step4.racing.domain.RacingInfo;
import step4.racing.ui.InputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ViewTest {
    private InputView inputView;
    private RacingInfo racingInfo;
    private RacingGame racingGame;
    private List<Car> cars;


    @BeforeEach
    void setUp() {
        inputView = new InputView();
        cars = new ArrayList<>();
    }

    @DisplayName("이름,횟수 유효성 체크")
    @ParameterizedTest
    @CsvSource(value = {"'',0"})
    void validateInput(String name, int position) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingInfo = new RacingInfo(name, position);
        });
    }

    @DisplayName("자동차이름 문자열 자르기")
    @ParameterizedTest
    @ValueSource(strings = {"강푸름,김푸름,최푸름"})
    void splitUserCarName(String inputName) {
        racingInfo = new RacingInfo(inputName, 10);
        assertThat(racingInfo.getNames()).containsExactly("강푸름", "김푸름", "최푸름");
    }


}
