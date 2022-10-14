package study.step5.domain.util;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step5.domain.car.Cars;

class StringUtilTest {

	@DisplayName("name 의 개수만큼 car 를 생성한다.")
	@Test
	void Given_NameList_Then_ReturnCars() {
		List<String> names = Arrays.asList("name1", "name2", "name3");
		Cars cars = StringUtil.toCars(names);

		assertThat(cars.size()).isEqualTo(names.size());
	}
}