package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
		@Test
		@DisplayName("String split 메서드를 테스트")
		void split() {
			String given = "1,2";
			String[] actual = given.split(",");

			assertAll(
				() -> assertThat(actual).contains("1"),
				() -> assertThat(actual).containsExactly("1", "2")
			);
		}

		@Test
		@DisplayName("String substring 메서드를 테스트")
		void substring() {
			String given = "(1,2)";
			String actual = given.substring(1, 4);

			assertThat(actual).isEqualTo("1,2");
		}

		@Test
		@DisplayName("String charAt 메서드 테스트")
		void char_at() {
			String given = "abc";

			assertThat(given.charAt(0)).isEqualTo('a');
		}

		@Test
		@DisplayName("String charAt 메서드 테스트")
		void char_at_fail() {
			String given = "abc";

			assertThatThrownBy(() -> {
				given.charAt(3);
			}).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("index out of range");
		}
}
