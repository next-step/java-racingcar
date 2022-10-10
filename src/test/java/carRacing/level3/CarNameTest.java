package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import carRacing.level3.error.NameLengthException;
import carRacing.level3.model.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

	@Test
	@DisplayName("자동차 이름은 5자를 초과할 수 없다")
	void 이름_길이_제한(){
		assertThatThrownBy(() -> {
			new CarName("longCarName");
		}).isInstanceOf(NameLengthException.class);
	}

}
