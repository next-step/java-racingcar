package study2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {
	
	Operator op = new Operator();
	
	@Test
	@DisplayName("덧셈 테스트")
	void addTest() {
		int result = op.add(1, 2);
		assertThat(result).isEqualTo(3);
	}

}
