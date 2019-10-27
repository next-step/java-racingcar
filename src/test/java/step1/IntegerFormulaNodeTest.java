package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("FormulaNode should")
class IntegerFormulaNodeTest {
    @Test
    @DisplayName("be shown as raw string in value")
    void nodeValueShouldShownAsRawStringType() {
        final FormulaNode node = new IntegerFormulaNodeValue(100);

        assertThat(node.asRaw()).isEqualTo("100");
    }

    @Test
    @DisplayName("be shown as raw string in operator")
    void nodeOperatorShouldShownAsRawStringType() {
        final FormulaNode node = IntegerFormulaNodeOperatorFactory.divide();

        assertThat(node.asRaw()).isEqualTo("/");
    }
}