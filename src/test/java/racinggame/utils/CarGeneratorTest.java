package racinggame.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CarGeneratorTest {

	@Test
	public void 콤마_자동차_생성_검증() {
		String carNames = "pobi, crong, honux";
		assertGeneration(carNames, "pobi", "crong", "honux");
	}

	private void assertGeneration(String carNames, String... expected) {
		assertThat(CarGenerator.generate(carNames))
				.extracting("name")
				.containsExactly(expected);
	}
}