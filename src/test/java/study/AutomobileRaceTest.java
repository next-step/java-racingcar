package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class AutomobileRaceTest {


	private AutomobileRaceService automobileRaceService;

	@BeforeEach
	void init() {
		automobileRaceService = new AutomobileRaceService(3);
	}

	@DisplayName("스프링에 - 을 이어붙일 때 나오는 결과를 테스트")
	@Test
	void StringAddTest() {
		String str = "";
		String result = "" + "-";
		assertThat("-").isEqualTo(result);
	}

	// Todo : 질문 부분 - @test 에도 NoSuchMethodException 같은 예외 던지기를 써도되는지, private 메소드 Test 방법은 Reflection 이 맞는지
	@Test
	void test() throws NoSuchMethodException {
		Method method = automobileRaceService.getClass().getDeclaredMethod("getRaceStatus");
		method.setAccessible(true);
	}
}
