package racing.model;

import java.util.Random;

public class RacingCar {

	// 경주 주행 기준 상수
	private static final int RACING_RANDOM_BOUND = 10;
	private static final int RACING_INCREASE_BOUND = 3;
	private static final int RACING_START_LOCATION = 0;

	// 자동차 주행 랜덤값 객체
	private static final Random randomNumberMaker = new Random();

	// 자동차 주행 거리
	private int location;

	public RacingCar() {

		// 객\체 생성 시 초기화
		this.location = RACING_START_LOCATION;
	}

	/**
	 * 랜덤값 생성하여, 4 이상 일 경우 자동차 주행(거리 + 1)
	 */
	public void racing() {

		// 랜던값 생성
		if (randomNumberMaker.nextInt(RACING_RANDOM_BOUND) > RACING_INCREASE_BOUND) {
			this.location++;
		}
	}

	/**
	 * 자동차 주행 거리 리턴
	 * @return : 자동차 주행 거리 정수 리턴
	 */
	public int getDistance() {

		return this.location;
	}

	public void move(CarConditional carConditional) {

		if (carConditional.isMove()) {

			this.location++;
		}
	}

	public MoveState checkCar() {

		if (randomNumberMaker.nextInt(RACING_RANDOM_BOUND) > RACING_INCREASE_BOUND) {

			return MoveState.MOVE;
		}

		return MoveState.STAY;
	}
}
