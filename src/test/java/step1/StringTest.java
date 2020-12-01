package step1;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class StringTest {
	@TestFactory
	@DisplayName("요구사항 1")
	Collection<DynamicTest> splitTest() {
		return Arrays.asList(
			DynamicTest.dynamicTest(
				"\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.",
				() -> assertThat("1,2".split(","))
					.containsExactly("1", "2")
			),
			DynamicTest.dynamicTest(
				"\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.",
				() -> assertThat("1".split(","))
					.containsExactly("1")
			)
		);
	}
}
