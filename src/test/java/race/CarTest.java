package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.domain.Car;
import race.domain.CarGroup;
import race.domain.CarName;
import race.domain.IllegalInputNameException;
import race.domain.MovePolicy;
import race.domain.SimpleMovePolicy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

	@DisplayName("자동차를 이동시키고 이동한 거리가 일치하는지 확인한다.")
	@Test
	void 자동차_거리_이동_TEST() {
		MovePolicy movePolicy = new SimpleMovePolicy();
		Car car = Car.of(movePolicy);
		IntStream.range(0, 10).forEach(i -> {
			car.move();
		});
		assertThat(car.nowDistance()).isEqualTo(10);
	}

	@DisplayName("자동차에 이름을 부여한다.")
	@Test
	void 자동차_이름부여_테스트() {
		MovePolicy movePolicy = new SimpleMovePolicy();
		Car newCar = Car.ofName(CarName.of("pobi"), movePolicy);
		assertThat(newCar.getNameValue()).isEqualTo("pobi");
	}

	@DisplayName("자동차 그룹에 콤마로 구분된 문자열을 받아 각각 이름을 부여하고 생성한다.")
	@Test
	void 자동차_그룹_이름부여_테스트() {
		String inputNames = "pobi,hglee";
		MovePolicy movePolicy = new SimpleMovePolicy();
		List<String> nameList = Arrays.asList(inputNames.split(","));
		CarGroup carGroup = CarGroup.ofCarNames("pobi,hglee", movePolicy);
		nameList.forEach(name -> assertThat(carGroup.ofCarName(name)).isTrue());
	}

	@DisplayName("사용자 입력값 중 5자를 초과한 이름이 포함된 여부 확인 테스트")
	@Test
	void 입력값_허용치_초과_테스트() {
		assertThatThrownBy(() -> {
			CarGroup.ofCarNames("test101010,test", new SimpleMovePolicy());
		})
			.isInstanceOf(IllegalInputNameException.class)
			.hasMessageContaining(String.format(IllegalInputNameException.ILLEGAL_INPUT_FORMAT_MESSAGE, CarName.MAX_INPUT_NAME_LENGTH));
	}
}
