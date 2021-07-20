package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

	@ParameterizedTest(name = "더하기 테스트 {index} [{arguments}]")
	@CsvSource(value = {
			"1,1,2",
			"10,10,20",
			"-1,1,0"
	})
	@DisplayName("더하기 테스트")
	void add(int x, int y, int sum) throws Exception {
		//given
		Operator operator = Operator.PLUS;

		//when
		int calculated = operator.calculate(x, y);

		//then
		assertThat(calculated).isEqualTo(sum);
	}


}