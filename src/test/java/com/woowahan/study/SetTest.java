package com.woowahan.study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setup() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("요구사항1:Set의 size() 메소드로 크기를 확인")
	@Test
	void setSizeTest() {
		//Given
		int expected = 3;

		//When
		int result = numbers.size();

		//Then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("요구사항2:Set의 contains() 메소드로 1, 2, 3이 존재하는지 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void setContainsTest(int value) {
		//Given
		//When
		boolean result = numbers.contains(value);

		//Then
		assertThat(result).isTrue();
	}

	@DisplayName("요구사항3:입력값에 따라 결과가 다른 경우의 테스트를 하나의 케이스로 구현")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void setContainsTrueOrFalseTest(int value, boolean expected) {
		//Given
		//When
		boolean result = numbers.contains(value);

		//Then
		assertThat(result).isEqualTo(expected);
	}
}
