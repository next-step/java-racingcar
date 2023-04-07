package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	public void test1(){
		String string = "1,2";
		String[] strings = string.split(",");

		Assertions.assertThat(strings).containsExactly("1", "2");
	}

	@Test
	public void test2(){
		String string = "1";
		String[] strings = string.split(",");

		Assertions.assertThat(strings).containsExactly("1");
	}

	@Test
	public void test3(){
		String string = "(1,2)";
		String expected = "1,2";
		int start = 1;
		int end = string.length()-1;

		String result = string.substring(start, end);

		Assertions.assertThat(result).isEqualTo(expected);
	}

	@Test
	public void test4(){
		String string = "abc";

		char a = string.charAt(0);
		char b = string.charAt(1);
		char c = string.charAt(2);

		Assertions.assertThat(a).isEqualTo('a');
		Assertions.assertThat(b).isEqualTo('b');
		Assertions.assertThat(c).isEqualTo('c');
	}

	@Test
	@DisplayName("String 클래스는 charAt에서 인자가 length보다 큰 경우 StringIndexOutOfBoundsException을 throw한다")
	public void test5(){
		String string = "abc";
		int outIndex = string.length();

		Assertions.assertThatThrownBy(() -> string.charAt(outIndex))
		          .isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}

