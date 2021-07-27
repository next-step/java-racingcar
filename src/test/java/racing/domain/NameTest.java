package racing.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NameTest {

	@DisplayName("이름을 입력하면 이름이 저장된다.")
	@ParameterizedTest
	@CsvSource(value = {"car1,car2,car3,car4"})
	public void createName(String name) {
		Name result = new Name(name);

		assertThat(result.printName()).isEqualTo(name);
	}

	@Test
	@DisplayName("이름에 빈값을 입력하면 예외처리가 발생된다.")
	public void nameEmptyCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			new Name("")
		);

		assertThatThrownBy(() -> new Name(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름이 빈값이 될 수 없습니다.");
	}

	@Test
	@DisplayName("이름이 5글자를 초과하면 예외처리가 발생된다.")
	public void nameLimitLengthCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			new Name("respect")
		);

		assertThatThrownBy(() -> new Name("respect"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름은 4자리까지 허용됩니다.");
	}

}