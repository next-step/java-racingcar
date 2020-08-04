import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("요구사항 1 : 1과 2 분리 테스트")
	public void test1() {
		String[] result = "1,2".split(",");
		
		assertThat(result).contains("1");
		assertThat(result).containsExactly("1","2");
	}
	
	@Test
	@DisplayName("요구사항 1 : 1만  포함하는지 테스트")
	public void test2() {
		String[] result = "1".split(",");
		
		assertThat(result).contains("1");
		assertThat(result).containsExactly("1");
	}
	
	@Test
	@DisplayName("요구사항 2 : substring으로 () 제거 후 1, 2 반환 테스트")
	public void test3() {
		String str = "(1,2)";
		String[] result = str.substring(1, str.length()-1).split(",");
		
		assertThat(result).contains("1");
		assertThat(result).containsExactly("1","2");
	}
	
	@Test
	@DisplayName("요구사항 3 : charAt을 이용해 특정 위치 문자 가져오기")
	public void test4() {
		String str = "abc";
		
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
		.isThrownBy(() -> { str.charAt(3); });
		
		
	}
	
}
