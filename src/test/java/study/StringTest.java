package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

	@Test
	@DisplayName("요구사항1 Split Test")
	void splitTest() {
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1","2");
		result = "1".split(",");
		assertThat(result).contains("1");
	}
	
	@Test
	@DisplayName("요구사항 2 Substring Test")
	void subStringTest() {
		String result = "";
		String Goal = "(1,2)";
		int startIdx = Goal.indexOf("(");
		int endIdx = Goal.indexOf(")");
		result = Goal.substring(startIdx+1,endIdx);
		assertThat(result).isEqualTo("1,2");
		
	}
	
}
