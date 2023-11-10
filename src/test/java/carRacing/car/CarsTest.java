package carRacing.car;

import static org.assertj.core.api.Assertions.assertThat;

import carRacing.numberMaker.MoveableNumberMaker;
import carRacing.numberMaker.NotMoveableNumberMaker;
import carRacing.numberMaker.NumberMaker;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

	@DisplayName("입력받은 이름들에 맞게 카 리스트를 만들 수 있다")
	@ParameterizedTest
	@ValueSource(ints = {3})
	void makeCarList(int carCount) {
		Cars carRacing = new Cars();
		List<Car> cars = carRacing.makeCars(carCount, new String[]{"pobi", "lee", "geun"});

		assertThat(cars.size()).isEqualTo(3);
		assertThat(cars.get(0).getName()).isEqualTo("pobi");
		assertThat(cars.get(1).getName()).isEqualTo("lee");
		assertThat(cars.get(2).getName()).isEqualTo("geun");

	}

	@DisplayName("랜덤값이 4이상 일 때 카 리스트들의 차를 움직인다")
	@ParameterizedTest
	@ValueSource(ints = {3})
	void moveCarList(int carCount) {
		Cars carRacing = new Cars();
		List<Car> cars = carRacing.makeCars(carCount, new String[]{"pobi", "lee", "geun"});
		NumberMaker numberMaker = new MoveableNumberMaker();
		carRacing.moveCars(numberMaker);

		assertThat(cars.get(0).getPosition()).isEqualTo(1);
		assertThat(cars.get(1).getPosition()).isEqualTo(1);
		assertThat(cars.get(2).getPosition()).isEqualTo(1);
	}

	@DisplayName("랜덤값이 4미안 일 때 카 리스트들의 차는 정지한다")
	@ParameterizedTest
	@ValueSource(ints = {3})
	void stopCarList(int carCount) {
		Cars carRacing = new Cars();
		List<Car> cars = carRacing.makeCars(carCount, new String[]{"pobi", "lee", "geun"});
		NumberMaker numberMaker = new NotMoveableNumberMaker();
		carRacing.moveCars(numberMaker);

		assertThat(cars.get(0).getPosition()).isEqualTo(0);
		assertThat(cars.get(1).getPosition()).isEqualTo(0);
		assertThat(cars.get(2).getPosition()).isEqualTo(0);
	}
}