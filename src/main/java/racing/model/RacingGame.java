package racing.model;

import java.util.List;

import racing.model.service.CarConditional;

public class RacingGame {

	private final RacingCars racingCars;

	public RacingGame(CarNames names) {

		this.racingCars = new RacingCars(names);
	}

	/**
	 * 레이싱 게임 한 사이클 시작 메서드
	 * @param carConditional : 랜덤 수 발생
	 */
	public void start(CarConditional carConditional) {

		this.racingCars.start(carConditional);
	}

	/**
	 * 레이싱 차량 리스트 리턴 메서드
	 * @return 레이싱 차량 리스트
	 */
	public List<RacingCar> getRacingCars() {

		return this.racingCars.getCars();
	}

	/**
	 * 우승자 발표 메서드
	 * @return : 주행거리가 가장 큰 차량들 리턴
	 */
	public String getWinner() {

		return this.racingCars.getWinnerNames();
	}
}
