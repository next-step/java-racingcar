package racing.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocationTest {

	@Test
	void move() {

		Location source = new Location(0);
		source.move();

		assertThat(source.getDistance()).isEqualTo(1);
	}

	@Test
	@DisplayName("Location 객체 생성 테스트")
	void initLocationTest() {

		Location location = new Location(0);
		assertThat(location).isEqualTo(new Location(0));

		assertThat(location).isEqualTo(new Location());
	}
}
