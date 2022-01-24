package calculator.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PivotContainerTest {

    final String input =  "1 + 2 * 10 / 3 - 8";

    @Test
    public void 유저가입력한_연산식은_정확하게_분리저장된다() {
        //given
        PivotContainer pivotContainer =  PivotContainer.from(input);

        //when
        List<Integer> numbers = pivotContainer.getNumbers();
        List<Operator> operators = pivotContainer.getOperators();

        //then
        Assertions.assertThat(numbers).containsExactly(1, 2, 10, 3, 8);
        Assertions.assertThat(operators).containsExactly(Operator.PLUS, Operator.MULTIPLY, Operator.DIVIDE, Operator.MINUS);

    }
}