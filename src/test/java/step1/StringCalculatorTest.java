package step1;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	StringCalculator stringCal;
	
	@BeforeEach
	void setUp() {
		stringCal = new StringCalculator();
	}
	
	@Test
	void doRecursiveCalculateTest() {
		String[] testCase2 = {" "};
		String[] testCase3 = {"2", "&", "3", "*", "4", "/", "2"};
		String[] testCase4 = {"2", "+", "3", "*", "4", "#", "2"};
		
		assertThatIllegalArgumentException().isThrownBy(() -> {
			StringCalculator.doRecursiveCalculate(testCase2);
			StringCalculator.doRecursiveCalculate(testCase3);
			StringCalculator.doRecursiveCalculate(testCase4);
		});
	}

}
