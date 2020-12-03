package com.woowahan.racing.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	private Car car;

	@BeforeEach
	void setup() {
		//초기에 한번 전진한 인스턴스 생성
		car = Car.getInstance();
		car.move(true);
	}

	@DisplayName("getInstance 메서드로 Car의 객체를 생성할 수 있다.")
	@Test
	void carInstance() {
		assertThat(car).isInstanceOf(Car.class);
	}

	@DisplayName("getDistance 메서드로 Car의 distance 정보를 받을 수 있다.")
	@Test
	void getDistance() {

		String result = car.getDistance();

		assertThat(result).isEqualTo("-");
	}

	@DisplayName("move 메서드의 파라미터로 true를 전달하면 distance의 문자열을 추가할 수 있다.")
	@Test
	void move() {

		car.move(true);
		String result = car.getDistance();

		assertThat(result).isEqualTo("--");
	}

	@DisplayName("clone 메서드로 car의 객체를 deep copy할 수 있다.")
	@Test
	void carClone() {

		Car otherCar = car.clone();

		assertAll(
			() -> assertThat(otherCar).isNotEqualTo(car),
			() -> assertThat(otherCar.getDistance()).isEqualTo(car.getDistance())
		);
	}

}