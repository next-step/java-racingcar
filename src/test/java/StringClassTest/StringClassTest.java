package StringClassTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class StringClassTest {

	@Test
	void splitStringArrayHavingTwoNumber() {
		// 요구사항 1-1 : "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1", "2");
	}
	
	@Test
	void splitStringArrayHavingOneNumber() {
		// 요구사항 1-2 : "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
		String[] result = "1".split(",");
		assertThat(result).containsExactly("1");
	}
	
	@Test
	void subStringRemoveParenthesis() {
		// 요구사항 2 : "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
		String targetString = "(1,2)";
		assertThat(
				targetString.substring(
						targetString.indexOf("(") + 1
						, targetString.indexOf(")")
						)
				)
		.isEqualTo("1,2");
		;
	}
}
