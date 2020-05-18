package study1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.setMaxLengthForSingleLineDescription;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * String 클래스에 대한 학습 테스트
 */

class StringTest {
	
	@Test
	void SplitTest() {
		String[] result = "1,2".split(",");

		assertThat(result).contains("1");
		assertThat(result).containsExactly("1", "2");
	}
	
	@Test
	void substringTest() {
		String str = "(1,2)".substring(1, 4);
		assertEquals("1,2", str);
	}
	
	@DisplayName("charAt 성공")
	@Test
	void charAtTest() {
		int i=2;
		String st = "abc";		
		char str = st.charAt(i);
		String transStr = Character.toString(str);
		
		i=6; // 아래 테스트 코드를 위해
		if(i > st.length()) {
			charAtFailTest();
		}
		assertEquals("c", transStr);
	}
		
	 @DisplayName("charAt 실패")
	 @Test void charAtFailTest() {
		 assertThatThrownBy(
				 () -> {
			throw new StringIndexOutOfBoundsException("error");
			
	 }).isInstanceOf(IndexOutOfBoundsException.class);
	}
	 
}
