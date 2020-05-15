package study2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CheckStringOrOperatorTest {
	
	CheckStringOrOpearator op = new CheckStringOrOpearator();
	
	@Test
	@DisplayName("null이나 공백체크")
	void inspectNullCheckTest() {
		
		assertThatIllegalArgumentException().isThrownBy(()
		-> {
			op.inspectNullCheck(" ");
		});
	}
	
	
	@ParameterizedTest
	@DisplayName("연산자 체크")
	@ValueSource(strings = {"%"})
	void notOperatorTest(String input) {
		assertThatIllegalArgumentException().isThrownBy(()
				-> {
			op.notOperator(input);
		});
	}
	
	@ParameterizedTest
	@DisplayName("모든 연산자 포함 여부 체크")
	@ValueSource(strings = {"+", "-", "*", "/"})
	void allOperatorIncludeCheckTest(String input) {
		assertThatIllegalArgumentException().isThrownBy(()
				-> {
			op.allOperatorIncludeCheck(input);
		});
	}
	
}
