package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("NumberUtil : 자동차 게임에 필요한 난수등을 생성하는 메소드를 포함함")
public class NumberUtilTest {

	@BeforeAll
	static void before() {
		System.out.print("생성된 숫자 : [");
	}

	@AfterAll
	static void after() {
		System.out.println("]");
	}

	@DisplayName("generateRandomDigitTest : 0~9 사이의 숫자를 하나 랜덤으로 생성함")
	@RepeatedTest(value = 10)
	public void generateRandomDigitTest() {
		int number = NumberUtil.generateRandomDigit();
		System.out.print(number + " ");
		assertThat(number)
			.isGreaterThanOrEqualTo(0)
			.isLessThanOrEqualTo(9);
	}
}
