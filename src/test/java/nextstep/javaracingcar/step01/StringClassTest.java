package nextstep.javaracingcar.step01;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringClassTest {

	@DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
	@Test
	public void test01() {
		final String sut = "1,2";
		final String[] actual = sut.split(",");
		assertThat(actual).containsExactly("1", "2");
	}

	@DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
	@Test
	public void test02() {
		final String sut = "1";
		final String[] actual = sut.split(",");
		assertThat(actual).hasSize(1).contains("1");
	}

	@DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
	@Test
	public void test03() {
		final String sut = "(1,2)";
		final String actual = sut.substring(1, sut.length()-1);
		assertThat(actual).isEqualTo("1,2");
	}

	@DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
	@Test
	public void test04() {
		final String sut = "abc";
		final char c0 = sut.charAt(0);
		final char c1 = sut.charAt(1);
		final char c2 = sut.charAt(2);
		assertThat(c0).isEqualTo('a');
		assertThat(c1).isEqualTo('b');
		assertThat(c2).isEqualTo('c');
	}

	@DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
	@Test
	public void test05() {
		final String sut = "abc";
		final int invalidIndex = sut.length();
		assertThatThrownBy(() -> sut.charAt(invalidIndex))
				.isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range: %d", invalidIndex);
	}
}
