package step1;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

	StringCalculator stringCal;
	
	@BeforeEach
	void setUp() {
		stringCal = new StringCalculator();
	}
	
	@Test
	void doRecursiveCalculateTest() {
		String[] testCase1 = {};
		String[] testCase2 = {" "};
		String[] testCase3 = {"2 & 3 * 4 / 2"};
		String[] testCase4 = {"2 + 3 * 4 # 2"};
		
		stringCal.doRecursiveCalculate(testCase1);
		stringCal.doRecursiveCalculate(testCase2);
		stringCal.doRecursiveCalculate(testCase3);
		stringCal.doRecursiveCalculate(testCase4);
		
		assertThatIllegalArgumentException()
		  .isThrownBy(() -> 
			  stringCal.doRecursiveCalculate(testCase1)
		).withMessageMatching("Index: \\d+, Size: \\d+");
	}

}
