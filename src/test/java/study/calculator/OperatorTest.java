package study.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {

	@Test
	@DisplayName("덧셈 연산자 테스")
	public void addition_test() throws Exception {
		//Given
		Addition addition = new Addition();
		//When
		int calculate = addition.calculate(1, 0);
		//Then
		assertThat(calculate).isEqualTo(1);
	}

	@Test
	@DisplayName("뺄셈 연산자 테스트")
	public void subtraction_test() throws Exception {
		//Given
		Subtraction subtraction = new Subtraction();
		//When
		int calculate = subtraction.calculate(1, 3);
		//Then
		assertThat(calculate).isEqualTo(-2);
	}

	@Test
	@DisplayName("곱셈 연산자 테스트")
	public void multiplication_test() throws Exception {
		//Given
		Multiplication multiplication = new Multiplication();
		//When
		int calculate = multiplication.calculate(1, 3);
		//Then
		assertThat(calculate).isEqualTo(3);
	}

	@Test
	@DisplayName("나눗셈 연산자 테스트")
	public void division_test() throws Exception {
		//Given
		Division division = new Division();
		//When
		int calculate = division.calculate(1, 3);
		//Then
		assertThat(calculate).isEqualTo(0);
	}
}
