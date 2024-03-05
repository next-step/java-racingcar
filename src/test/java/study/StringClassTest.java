package study;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("String 클레스에 대한 학습 테스트")
public class StringClassTest {

	@Nested
	@DisplayName("split() 메서드는 regex 를 기준으로 문자열을 분리한다. ")
	class 요구사항1 {

		@Test
		@DisplayName("문자열 1,2를 ',' 기준으로 분리하면 [1,2]를 반환한다.")
		void 요구사항1_1() {
			//given
			String str = "1,2";
			String regex = ",";

			//when
			String[] splitStr = str.split(regex);

			//then
			assertThat(splitStr).containsExactly("1", "2");
		}

		@Test
		@DisplayName("문자열 1을 ',' 기준으로 분리하면 [1]을 반환한다.")
		void 요구사항1_2() {
			//given
			String str = "1";
			String regex = ",";

			//when
			String[] splitStr = str.split(regex);

			//then
			assertThat(splitStr).containsExactly("1");
		}
	}

	@Test
	@DisplayName("문자열 (1,2)에서 ()를 제거하고 1,2를 반환한다.")
	void 요구사항2() {
		//given
		String str = "(1,2)";

		//when
		String substring = str.substring(1, str.length() - 1);

		//then
		assertThat(substring).isEqualTo("1,2");
	}

	@Nested
	@DisplayName("charAt() 메서드 테스트")
	class 요구사항3 {
		@Test
		@DisplayName("올바른 인덱스면 해당 인덱스의 문자를 가져온다")
		void 요구사항3_1() {
			//given
			String str = "abc";

			//when
			char c = str.charAt(0);

			//then
			assertThat(c).isEqualTo('a');
		}

		@Test
		@DisplayName("올바른지 못한 인덱스면 StringIndexOutOfBoundsException가 발생한다.")
		void 요구사항3_2() {
			//given
			String str = "abc";

			//when & then
			assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
				.isThrownBy(() -> str.charAt(str.length())
				);
		}
	}
}
