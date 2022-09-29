package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NameTest {

	@DisplayName("이름이 생성된다.")
	@Test
	void createName() {
		Name name = new Name("수정");
		assertThat(name).isEqualTo(new Name("수정"));
	}

	@DisplayName("이름이 5자 이상이면 에러를 반환한다.")
	@Test
	void validateNameLongerThenFive() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				new Name("수정입니다");
			});
	}

	@DisplayName("이름이 공백이면 에러를 반환한다.")
	@Test
	void validateNameIsEmpty() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				new Name("");
			});
	}
}
