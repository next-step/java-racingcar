package study.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyNumberTest {
	@Test
	void create(){
		assertThat(new MyNumber("1")).isEqualTo(new MyNumber(1));
	}
}
