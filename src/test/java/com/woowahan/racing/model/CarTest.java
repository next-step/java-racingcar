package com.woowahan.racing.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.woowahan.racing.constant.Message;

class CarTest {

	private static final String SETUP_CAR_NAME = "자동차1";
	private Car car;

	@BeforeEach
	void setup() {
		//초기에 한번 전진한 인스턴스 생성
		car = Car.createCar(SETUP_CAR_NAME);
		car.move(true);
	}

	@DisplayName("createCar 메서드로 Car의 객체를 생성할 수 있다.")
	@Test
	void createCar() {
		assertThat(car).isInstanceOf(Car.class);
	}

	@DisplayName("getName 메서드로 Car의 name 정보를 받을 수 있다.")
	@Test
	void getName() {

		String result = car.getName();

		assertThat(result).isEqualTo(SETUP_CAR_NAME);
	}

	@DisplayName("getDistance 메서드로 Car의 distance 정보를 받을 수 있다.")
	@Test
	void getDistance() {

		int result = car.getDistance();

		assertThat(result).isEqualTo(1);
	}

	@DisplayName("move 메서드의 파라미터로 true를 전달하면 distance의 문자열을 추가할 수 있다.")
	@Test
	void move() {

		car.move(true);
		int result = car.getDistance();

		assertThat(result).isEqualTo(2);
	}

	@DisplayName("clone 메서드로 car의 객체를 deep copy할 수 있다.")
	@Test
	void carClone() {

		Car otherCar = car.clone();

		assertAll(
			() -> assertThat(otherCar).isNotEqualTo(car),
			() -> assertThat(otherCar.getName()).isEqualTo(car.getName()),
			() -> assertThat(otherCar.getDistance()).isEqualTo(car.getDistance())
		);
	}

	@DisplayName("createCar 메서드로 null or empty 또는 5글자 이상의 문자를 전달하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"abcdef", "가나다라마바사아자"})
	void carNameLength(String name) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Car.createCar(name);
			}).withMessage(Message.MSG_CAR_NAME_LENGTH_ERROR);
	}

}