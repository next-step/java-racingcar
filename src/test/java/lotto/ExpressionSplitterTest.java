package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ExpressionSplitterTest {

    @DisplayName("ExpressionSplitter 동작 테스트")
    @Test
    public void test() {

        List<String> refineExpression = new ArrayList<>();
        refineExpression.add("2:1,3");

        List<String> split = ExpressionSplitter.split(refineExpression, new DelimiterList());

        assertAll(
                ()->assertThat(split).contains("2"),
                ()->assertThat(split).contains("1"),
                ()->assertThat(split).contains("3")
        );
    }

}
