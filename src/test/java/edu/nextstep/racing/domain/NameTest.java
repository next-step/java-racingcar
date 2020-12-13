package edu.nextstep.racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.nextstep.racing.domain.game.cars.car.Name;

@DisplayName("Location : 자동차의 이름에 대한 원시값 포장 클래스")
class NameTest {

	@DisplayName("equals : 인스턴스 변수 name이 같으면 동일한 객체임.")
	@Test
	void testEquals() {
		assertThat(new Name("pobi")).isEqualTo(new Name("pobi"));
	}

	@DisplayName("getValue : name을 String 문자열타입 그대로 리턴함.")
	@Test
	void getValue() {
		assertThat(new Name("pobi").getValue()).isEqualTo("pobi");
	}
}