package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class CalTest {

	@Test
	void null_값(){
		int result = Cal.cal(null);
		assertThat(result).isEqualTo(0);
	}
}
