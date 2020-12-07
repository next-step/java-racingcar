package step1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.MethodOrderer.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : byungkyu
 * @date : 2020/11/30
 * @description : String 클래스에 대한 학습 테스트
 **/
@TestMethodOrder(OrderAnnotation.class)
class StringTest {

	@Order(1)
	@DisplayName("1.1. \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
	@Test
	void splitTwoValueIsCorrect() {
		String arg = "1,2";
		String[] splitValue = arg.split(",");
		assertThat(splitValue.length).isEqualTo(2);
		assertThat(splitValue).contains("1", "2");
	}

	@Order(2)
	@DisplayName("1.2. \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
	@Test
	void splitOneValueWithCommaIsCorrect() {
		String arg = "1,";
		String[] splitValue = arg.split(",");
		assertThat(splitValue.length).isEqualTo(1);
		assertThat(splitValue).containsExactly("1");
	}

	@Order(3)
	@DisplayName("2.1. \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
	@Test
	void splitValuesUsingSubstringIsCorrect() {
		String arg = "(1,2)";
		String[] splitValue = arg.substring(arg.indexOf("(") + 1, arg.indexOf(")")).split(",");
		assertThat(splitValue.length).isEqualTo(2);
		assertThat(splitValue).contains("1", "2");
	}

	@Order(4)
	@DisplayName("3.1. \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
	@ParameterizedTest
	@ValueSource(strings = {"a", "b", "c"})
	void getSentenceWithUsingCharAtIsCorrect(String arg) {
		String target = "abc";
		char c = target.charAt(target.indexOf(arg));
		assertThat(target).contains(Character.toString(c));
	}

	@Order(5)
	@DisplayName("3.2. \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
	@ParameterizedTest
	@ValueSource(strings = {"n", "e", "x", "t"})
	void getSentenceWithUsingCharAtIsNotCorrect(String arg) {
		String target = "abc";
		assertThatThrownBy(() -> {
			char c = target.charAt(target.indexOf(arg));
		}).isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
