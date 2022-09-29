package racing.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.model.Name;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameRequestTest {

	@DisplayName("자동차 이름은 쉼표(,)를 기준으로 이름을 생성한다.")
	@ParameterizedTest
	@CsvSource(value = {"0,a", "1,b", "2,c"})
	void createName(int input, String expected) {
		GameRequest gameRequest = new GameRequest("a,b,c", 3);
		List<Name> names = gameRequest.getNames();

		assertThat(names).hasSize(3);
		assertThat(names.get(input)).isEqualTo(new Name(expected));
	}
}
