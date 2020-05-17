package study3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
	
	OutputView ov;
	
	@Test
	@DisplayName("Output Test")
	void OutputView() {
		int[] in = {5 , 6,  8};
		ov = new OutputView();
		int[] result = ov.OutputView(in);
		
		assertThat(result).isEqualTo(in);
	}
}
