package step4.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	Car car;

	@BeforeEach
	void beforeEach(){
		car = new Car("namkun");
	}

	@Test
	@DisplayName("생성된 자동차의 움직임 횟수는 0으로 초기화 되어있어야 한다.")
	void initCarTest(){
		assertThat(car.getMoveCnt()).isEqualTo(0);
	}

	@Test
	@DisplayName("자동차의 이름은 객체 생성시의 값을 초기화 되어야 한다")
	void initCarNameTest(){
		assertThat(car.getName()).isEqualTo("namkun");
	}

	@Test
	@DisplayName("자동차가 제대로 움직이는가?")
	void moveCarTest(){
		 car.move();
		 assertThat(car.getMoveCnt()).isEqualTo(1);
	}

}