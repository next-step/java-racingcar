package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import carRacing.level3.model.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocationTest {

	@Test
	@DisplayName("위치는 음수가 될 수 없다")
	void 위치_음수_테스트(){
		assertThatThrownBy(() -> {
			new Location(-1);
		}).isInstanceOf(RuntimeException.class);
	}

}
