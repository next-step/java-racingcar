package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racing.model.service.CarConditional;

public class RacingCars {

	// 레이싱 차량 저장 리스트
	private final List<RacingCar> cars;

	public RacingCars(CarNames names) {

		this.cars = initNameRacingCars(names);
	}

	private List<RacingCar> initNameRacingCars(CarNames names) {

		List<RacingCar> racingCars = new ArrayList<>();

		for (CarName name : names.getCarNames()) {

			racingCars.add(new RacingCar(name));
		}

		return racingCars;
	}

	/**
	 * 유저가 입력한 수만큼 자동차 객체를 생성하는 메서드
	 * @param racingCarNumber : 유저가 입력한 레이싱 경주 차량 댓수
	 * @return : 생성한 경주 차량 리스트 리턴
	 */
	private List<RacingCar> initNumberRacingCars(int racingCarNumber) {

		List<RacingCar> initRacingCars = new ArrayList<>();
		for (int i = 0; i < racingCarNumber; i++) {

			initRacingCars.add(new RacingCar());
		}

		return initRacingCars;
	}

	/**
	 * 자동차 객체 리스트에 있는 모든 차량 레이스 시작
	 * @param carConditional: 레이싱 자동차 움직임 제어
	 */
	public void start(CarConditional carConditional) {

		this.cars.forEach(racingCar -> racingCar.move(carConditional));
	}

	/**
	 * 거리를 출력하기 위해 자동차 객체 리턴
	 * @return : 자동차 객체 리스트 리턴
	 */
	public List<RacingCar> getCars() {

		return this.cars;
	}

	public String getWinnerNames() {

		// 최대 주행거리
		int maxDistance = this.cars.stream()
			.mapToInt(RacingCar::getDistance)
			.max()
			.orElse(0);

		// 최대 주행거리 운전자명 집계
		return this.cars.stream()
			.filter(racingCar -> racingCar.getDistance() == maxDistance)
			.map(RacingCar::getCarName)
			.collect(Collectors.joining(", "));
	}
}
