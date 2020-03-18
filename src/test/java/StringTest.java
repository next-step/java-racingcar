import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
	@Test
	public void split() {
		String combined = "1,2";
		assertThat(combined.split(","))
				.contains("1", "2");

		String justOne = "1";
		assertThat(justOne.split(","))
				.containsExactly("1");
	}

	@Test
	public void subString() {
		String bracketString = "(1,2)";
		assertThat(bracketString.substring(
				1,
				bracketString.length()-1))
				.isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt 에 없는 글자 검색 시 StringIndexOutOfBoundsException 던지는지 확인")
	void charAt() {
		assertThatThrownBy(()->{
			"abc".charAt(4);
		}).isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessageMatching("String index out of range: \\d+");
	}

}
