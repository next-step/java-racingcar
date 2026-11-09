package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	
	@Test
	@DisplayName("요구사항 1 : 1과 2로 잘 분리되는지 확인하는 학습 테스트")
	void split() {
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1","2");
	}
	
	@Test
	@DisplayName("요구사항 2 : String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
	void substring() {
		String result ="(1,2)".substring(1,4);
		assertThat(result).isEqualTo("1,2");
	}
	
	@Test
	@DisplayName("요구사항 3 : String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
	void chatAt() {
		
		assertThatThrownBy(() -> "abc".charAt(4)).isInstanceOf(Exception.class)
        .hasMessageContaining("out of bounds for length 3");
		
	}
	
}
