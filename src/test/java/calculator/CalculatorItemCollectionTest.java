package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorItemCollectionTest {

    @Test
    @DisplayName("사용자 입력을 파싱하여 String List를 반환한다.")
    void parsingInputString() {

        //given
        String input = "1 + 2 * 4 / 3";
        CalculatorItemCollection collection = new CalculatorItemCollection(input);

        //when
        List<String> items = collection.getItem();

        //then
        assertThat(items).hasSize(7);
        assertThat(items.get(0)).isEqualTo("1");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 2", "3 * 5 + 2 -", "+ 1"})
    @DisplayName("입력이 올바르지 않을 경우(순서오류, 숫자와 연산자의 갯수 오류) 에러를 뱉는다.")
    void isNotValidThrowIllegalArgumentException(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculatorItemCollection collection = new CalculatorItemCollection(input);
        });
    }
}
