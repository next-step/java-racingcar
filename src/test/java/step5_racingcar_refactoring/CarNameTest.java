package step5_racingcar_refactoring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step5_racingcar_refactoring.domain.CarName;

public class CarNameTest {

	@DisplayName("이름이 null이거나 빈 값인 경우 예외가 발생 테스트")
	@Test
	void constructor_NullOrEmptyName_ThrowsException() {
		assertThrows(RuntimeException.class, () -> new CarName(null));
		assertThrows(RuntimeException.class, () -> new CarName(""));
		assertThrows(RuntimeException.class, () -> new CarName(" "));
	}

	@DisplayName("이름이 5글자 이상인 경우 예외가 발생 테스트")
	@Test
	void constructor_NameLengthGreaterThanFive_ThrowsException() {
		assertThrows(RuntimeException.class, () -> new CarName("abcdef"));
		assertThrows(RuntimeException.class, () -> new CarName("123456"));
	}

	@DisplayName("이름이 유효한 경우 객체 생성 테스트")
	@Test
	void constructor_ValidName_CreatesObject() {
		CarName carName = new CarName("car");
		assertEquals("car", carName.getCarName());
	}

}
