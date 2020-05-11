package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.util.Arrays;

public class StringStudyTest {
	StringStudy StringStudy = new StringStudy();

	@Test
	public void testSplitTest() {
		String[] result1 = StringStudy.splitTest("1,2", ",");
		String[] result2 = StringStudy.splitTest("1", ",");

		assertThat(result1).contains(new String[] { "1", "2" });
		assertThat(result1).containsExactly(new String[] { "1", "2" });
		assertThat(result2).contains(new String[] { "1" });
		assertThat(result2).containsExactly(new String[] { "1" });
	}

	@Test
	public void testRemoveBracket() {
		String result = StringStudy.removeBracket("(1,2)");

		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt() 사용 시 위치 값을 벗어났을 경우 StringIndexOutOfBoundsException 발생 테스트")
	public void testCharAtTest() {
		// using assertThatThrownBy
		assertThatThrownBy(() -> {
			StringStudy.charAtTest("abc", -1);
		}).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("range: -1");
		
		// using assertThatExceptionOfType
		assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
			StringStudy.charAtTest("abc", 3);
		}).withMessageMatching("String index out of range: 3");
		
		assertThatNullPointerException().isThrownBy(()->{
			StringStudy.charAtTest(null, 0);
		});
		
		// Separating the Exception From the Assertion
		Throwable thrown = catchThrowable(() -> {
			StringStudy.charAtTest("abc", 4);
		});

		assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessageMatching("String index out of range: 4");
	}
}