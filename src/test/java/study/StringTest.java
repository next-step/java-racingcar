package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {
	@Test
	void split함수에_컴마를_인자로_받으면_컴마를_기준으로_나누어진다() {
		String[] result = "1,2".split(",");
		assertThat(result).contains("1");
		assertThat(result).contains("2");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	void substring함수에_시작인덱스와_길이에서_1뺀값을_넣으면_첫번째와_마지막문자가_제거된다() {
		String input = "(1,2)";
		assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
	}

	@Test
	void charAt함수_인자에_범위를_벗어나는_값을_넣으면_StringIndexOutOfBoundsException을_던진다() {
		String input = "abc";
		assertThatThrownBy(() -> {
			input.charAt(input.length());
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
		  .hasMessageContaining("String index out of range: " + input.length());
	}
}
