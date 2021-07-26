package racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

	private Car car;

	@BeforeEach
	void carInit() {
		car = new Car("test");
	}

	@Test
	@DisplayName("Car 오브젝트 초기 move 값 확인")
	void init() {
		assertThat(car.getMove()).isEqualTo(0);
	}

	@Test
	@DisplayName("Car 오브젝트 초기 move 값 확인 실패 케이스")
	void failInit() {
		assertThat(car.getMove()).isNotEqualTo(1);
	}

	@Test
	@DisplayName("Car 오브젝트의 이름이 test로 생성되었는가?")
	void getName() {
		assertThat(car.getName()).isEqualTo("test");
	}

	@Test
	@DisplayName("Car 오브젝트의 이름이 test2와 다른가?")
	void failGetName() {
		assertThat(car.getName()).isNotEqualTo("test2");
	}

	@Test
	@DisplayName("move() 메서드 호출 시 randomValue가 4이상이면 move 값 증가")
	void move() {
		car.move(5);
		assertThat(car.getMove()).isEqualTo(1);
	}

	@Test
	@DisplayName("move() 메서드 호출 시 randomValue가 4이하면 move 값 그대로")
	void failMove() {
		car.move(3);
		assertThat(car.getMove()).isEqualTo(0);
	}

	@Test
	@DisplayName("showDistanceOfMovement() 메서드 호출 시 이동거리 결과 출력")
	void showDistanceOfMovement() {
		car.move(5);
		car.move(5);

		assertThat(car.showDistanceOfMovement()).isEqualTo("test : --");
	}

	@Test
	@DisplayName("showDistanceOfMovement() 메서드 호출 시 이동거리 결과 출력 실패 케이스")
	void failShowDistanceOfMovement() {
		car.move(5);
		car.move(5);

		assertThat(car.showDistanceOfMovement()).isEqualTo("test : --");
	}

	@ParameterizedTest
	@CsvSource(value = {"test:true", "test2:true", "test3:true", "test5555:false"}, delimiter = ':')
	@DisplayName("validate() 메서드 호출 시 이름 검증")
	void validate(String carName, boolean expected) {
		assertThat(Car.validate(carName)).isEqualTo(expected);
	}
}