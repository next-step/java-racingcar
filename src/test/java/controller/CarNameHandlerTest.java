package controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameHandlerTest {
    private static CarNameHandler carNameHandler;

    @BeforeAll
    static void initAll() {
        carNameHandler = new CarNameHandler();
    }

    @Test
    @DisplayName("입력을 ,를 기준으로 나누는지 테스트")
    void splitCarNamesTest() {
        String[] result = carNameHandler.splitCarNames("pobi,woni,jun");
        String[] expected = {"pobi", "woni", "jun"};

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차의 이름이 5자 초과하는지 테스트")
    void checkCarNamesTest() {
        String[] input = {"pobisadf", "woniasdf", "junasdfasdfas"};
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> carNameHandler.checkCarNames(input));
    }
}
