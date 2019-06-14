package camp.nextstep.edu.util;

import camp.nextstep.edu.calculator.OperatorType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@SuppressWarnings("NonAsciiCharacters")
class ListUtilsTest {

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2", "3,-1", "4,-2"})
    void getForInteger_변환_성공(Integer index, Integer expected) {
        final List<String> elements = Arrays.asList("0", "1", "2", "-1", "-2");
        Integer result = ListUtils.getForInteger(elements, index);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getForInteger_입력받은_리스트가_null이면_예외_발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ListUtils.getForInteger(null, 0));
    }

    @Test
    void getForInteger_유효하지_않은_index인_경우_예외_발생() {
        final List<String> elements = Arrays.asList("1", "2", "3");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> ListUtils.getForInteger(elements, 100));
    }

    @Test
    void getForInteger_Integer로_변환할_수_없는_경우_예외_발생() {
        final List<String> elements = Arrays.asList("1.1", "2.2", "3.3");
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> ListUtils.getForInteger(elements, 0));
    }

    @ParameterizedTest
    @CsvSource({
            "0,+",
            "1,-",
            "2,*",
            "3,/"
    })
    void getForOperatorType_변환_성공(Integer index, String expected) {
        final List<String> elements = Arrays.asList("+", "-", "*", "/");
        final OperatorType actualOperatorType = ListUtils.getForOperatorType(elements, index);
        final OperatorType expectedOperatorType = OperatorType.from(expected);
        assertThat(actualOperatorType).isEqualTo(expectedOperatorType);
    }

    @Test
    void getForOperatorType_입력받은_리스트가_null이면_예외_발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ListUtils.getForOperatorType(null, 0));
    }

    @Test
    void getForOperatorType_유효하지_않은_index인_경우_예외_발생() {
        final List<String> elements = Arrays.asList("+", "-", "*", "/");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> ListUtils.getForOperatorType(elements, 100));
    }

    @Test
    void getForOperatorType_OperatorType으로_변환할_수_없는_경우_예외_발생() {
        final List<String> elements = Arrays.asList("#", "$", "%");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ListUtils.getForOperatorType(elements, 0));
    }

}
