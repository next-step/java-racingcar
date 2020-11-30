package com.woowahan.study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

	@DisplayName("요구사항1: \"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인")
	@Test
	void splitOneAndTwoTest() {
		//Given
		String target = "1,2";
		String delimiter = ",";

		//When
		String[] result = target.split(delimiter);
		//Then
		assertAll(
			() -> assertThat(result).contains("1", "2"),
			() -> assertThat(result).containsExactly("1", "2")
		);
	}

	@DisplayName("요구사항1: \"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
	@Test
	void splitOneTest() {
		//Given
		String target = "1";
		String delimiter = ",";

		//When
		String[] result = target.split(delimiter);

		//Then
		assertThat(result).containsExactly(target);
	}

	@DisplayName("요구사항2: \"(1,2)\"값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하는지 확인")
	@Test
	void substringTest() {
		//Given
		String target = "(1,2)";
		String expected = "1,2";

		//When
		String result = target.substring(1, target.length() - 1);

		//Then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("요구사항3: \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오고 맞는지 검증")
	@ParameterizedTest
	@CsvSource(value = {"0:'a'", "1:'b'", "2:'c'"}, delimiter = ':')
	void chartAtTest(int index, char expected) {
		//Given
		String target = "abc";

		//When
		char result = target.charAt(index);

		//Then
		assertThat(result).isEqualTo(expected);

	}

	@DisplayName("요구사항3: String의 charAt() 메소드를 사용할 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
	@Test
	void charAtOutOfBoundTest() {
		//Given
		String target = "abc";
		int outOfBoundIndex = target.length();

		//When //Then
		assertThatThrownBy(() -> target.charAt(outOfBoundIndex))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining(String.format("String index out of range: %s", outOfBoundIndex));
	}
}
