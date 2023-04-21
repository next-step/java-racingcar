package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    public void beforeEach() {
        racingGame = new RacingGame();
    }

    @ParameterizedTest
    @CsvSource(value = {"a,b,c|3", "a|1", "a,b,c,d,e,f|6"}, delimiter = '|')
    @DisplayName("자동차 이름 추가에 따른 자동차 생성 테스트")
    public void initCarsWithNameTest(String input, int result) {
        racingGame.initCars(input);
        assertThat(racingGame.getCars().size()).isEqualTo(result);
    }

    @Test
    @DisplayName("자동차 이름 추가에 따른 자동차 생성 예외테스트")
    public void initCarsWithNameLengthExceptionTest() {
        assertThatThrownBy(() -> racingGame.initCars("abcdef,ab"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 추가에 따른 자동차 생성 예외테스트")
    public void initCarsWithNameDuplicateExceptionTest() {
        assertThatThrownBy(() -> racingGame.initCars("a,a,b,c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름을 가진 자동차가 있습니다.");
    }

    @Test
    @DisplayName("자동차 이름 추가에 따른 자동차 생성 예외테스트")
    public void initCarsWithBlankExceptionTest() {
        assertThatThrownBy(() -> racingGame.initCars(",b,c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 공백일 수는 없습니다.");
    }
}
