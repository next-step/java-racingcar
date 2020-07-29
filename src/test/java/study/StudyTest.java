package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StudyTest {
	@Test
	void split() {
		String[] result = "1,2".split(",");
		assertThat(result).contains("1");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	public void substring() {
		String str = "(1,2)";
		assertThat(str.substring(str.indexOf("(")+1, str.indexOf(")"))).contains("1,2");
	}

	@Test
	public void charAt() {
		assertThatThrownBy(() -> {
			"abc".charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
