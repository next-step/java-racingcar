package im.juniq.studytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SplitTest {
	@Test
	void testSplit() {
		String source = "1,2";

		String[] splitedText = source.split(",");

		assertThat(splitedText).containsExactly("1", "2");
	}
}
