package step5.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step5.strategy.FixMoveStrategy;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

	Cars cars;

	@BeforeEach
	void beforeEach(){
		cars = new Cars("hi,ho,hii,huu");
	}

	@Test
	void 자동차들_생성_테스트() {
		assertThat(cars.getCars()).hasSize(4);
	}

	@Test
	void 자동차들_움직임테스트(){
		cars.decideMove(new FixMoveStrategy());
		cars.getCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(1));
	}
}