package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperandTest {
	@Test
	@DisplayName("숫자인 문자열 입력시 정상적으로 Operand를 생성한다.")
	void create_ReturnOperand() {
		Operand operand = Operand.create("123");

		assertThat(operand).isInstanceOf(Operand.class);
		assertThat(operand.getValue()).isEqualTo(123);
	}

	@Test
	@DisplayName("숫자가 아닌 문자열 입력시 IllegalArgumentException을 발생한다.")
	void create_ThrowIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Operand.create("test"))
			.withMessage(Message.INVALID_STRING_FOR_OPERAND);
	}

}
