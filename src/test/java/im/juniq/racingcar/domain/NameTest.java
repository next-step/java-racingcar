package im.juniq.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
	@DisplayName("이름 생성")
	@ParameterizedTest
	@ValueSource(strings = {"pobi"})
	void createName(String name) {
		Name createdName = new Name(name);
		assertThat(createdName.value()).isEqualTo(name);
	}

	@DisplayName("이름은 5글자 이하만 허용한다")
	@ParameterizedTest
	@ValueSource(strings = {"pobi66"})
	void createNameWithCheckNameLength(String name) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
	}
}