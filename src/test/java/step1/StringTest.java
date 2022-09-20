package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	public void 요구사항1() throws Exception {
		String str = "1,2";
		String[] arr = str.split(",");

		assertThat(arr).contains("1");
		assertThat(arr).containsExactly("1", "2");
	}

	@Test
	public void 요구사항2() throws Exception {
		String str = "(1,2)";
		String substring = str.substring(1, str.length() - 1);

		assertThat(substring).isEqualTo("1,2");
	}

	@Test
	@DisplayName("특정 위치 문자 확인")
	public void 요구사항3() throws Exception {
		String str = "abc";

		assertThat(str.charAt(0)).isEqualTo('a');
		assertThat(str.charAt(1)).isEqualTo('b');
		assertThat(str.charAt(2)).isEqualTo('c');
	}

	@Test
	@DisplayName("StringIndexOutOfBoundsException 확인")
	public void 요구사항4() throws Exception {
		String str = "abc";

		assertThatThrownBy(() -> str.charAt(3))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
