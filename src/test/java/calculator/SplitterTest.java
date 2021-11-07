package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SplitterTest {
    private List<MyNumber> myNumbers;
    private List<Operator> operators;
    private String expression;

    @BeforeEach
    public void init() {
        myNumbers = IntStream.rangeClosed(0, 4).boxed().map(MyNumber::new).collect(Collectors.toList());
        operators = Stream.of("+", "-", "*", "/").map(Operator::of).collect(Collectors.toList());
        expression = "0 + 1 - 2 * 3 / 4";
    }

    @Test
    @DisplayName("연산 문자열 split")
    void split() {
        Splitter splitter = new Splitter(this.expression);
        assertThat(splitter.getMyNumbers().equals(myNumbers)).isTrue();
        assertThat(splitter.getOperators().equals(operators)).isTrue();
    }

    @Test
    @DisplayName("입력 값 오류(null)")
    public void InputExceptionWithNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Splitter(null))
                .withMessage("invalid expression : null");
    }

    @Test
    @DisplayName("입력 값 오류(empty string)")
    public void InputExceptionWithEmptyString() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Splitter(""))
                .withMessage("invalid expression : ");
    }
}