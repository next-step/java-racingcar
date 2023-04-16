package carRacing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocationTest {

	@DisplayName("위치 더하기.")
	@Test
	void test1() {
		Location location = new Location(0);
		location.plus();
		assertThat(location).isEqualTo(new Location(1));
	}

	@DisplayName("위치 비교하기.")
	@Test
	void test2() {
		Location location = new Location(4);
		assertThat(location.isGreater(new Location(3))).isTrue();
		assertThat(location.isGreater(new Location(5))).isFalse();
	}
}
