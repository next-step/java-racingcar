package study2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void calculateTest() {
		
		Calculator cal = new Calculator();
		int result = cal.calculate("1 - 2 + 5 / 2 * 9".split(" "));
		assertThat(result).isEqualTo(18);
		int result2 = cal.calculate("3 + 4 - 6 * 10 / 5".split(" ")); // 실패하는 코드 
		assertThat(result2).isEqualTo(5);
	}

}
