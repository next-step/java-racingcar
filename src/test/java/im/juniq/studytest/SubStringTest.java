package im.juniq.studytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubStringTest {
	@Test
	void testSubString() {
		String source = "(1,2)";

		String substringText = source.substring(1, source.length() - 1);

		assertThat("1,2").isEqualTo(substringText);
	}
}
