package ch2;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	void null값제공시_0이나와야함() {
		int result = Calculator.calc(null);
		assertThat(result).isEqualTo(0);
		int result2 = Calculator.calc("");
		assertThat(result2).isEqualTo(0);
	}

	@Test
	void 문자하나를_넣으면_숫자가_나옴() {
		int result = Calculator.calc("1");
		assertThat(result).isEqualTo(1);
		int result2 = Calculator.calc("2");
		assertThat(result2).isEqualTo(2);
	}

	@Test
	void 컴마구분자를_넣으면_더하기가_된다() {
		int result = Calculator.calc("1,2");
		assertThat(result).isEqualTo(3);
		int result2 = Calculator.calc("3,5");
		assertThat(result2).isEqualTo(8);
	}

	@Test
	void 구분자를_콜론으로_사용할_수_있다() {
		int result = Calculator.calc("1,2:3");
		assertThat(result).isEqualTo(6);
		int result2 = Calculator.calc("1:3:6");
		assertThat(result2).isEqualTo(10);
	}

	@Test
	void 커스텀_구분자를_지정하면_해당_문자가_덧셈으로_처리된다() {
		int result = Calculator.calc("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
		int result2 = Calculator.calc("//&\n1&2&3");
		assertThat(result2).isEqualTo(6);
	}


	@Test
	void 음수를_전달하면_runtime_exception이_발생한다() throws RuntimeException {
		assertThatThrownBy(() ->{
			Calculator.calc("-1,3,4");
		}).isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() ->{
			Calculator.calc("1,3,-4");
		}).isInstanceOf(RuntimeException.class);
	}

}
