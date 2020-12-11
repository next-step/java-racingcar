package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racing.model.service.CarConditional;

public class RacingCars {

	// 레이싱 차량 저장 리스트
	private final List<RacingCar> cars;

	/**
	 * 가상 레이스 테스트를 위해 만든 생성자.
	 * @param cars : 임의로 만든 가상 자동차 객체 리스트
	 */
	public RacingCars(List<RacingCar> cars) {
		this.cars = cars;
	}

	public RacingCars(CarNames names) {

		this.cars = initNameRacingCars(names);
	}

	/**
	 * 유저 자동차 리스트 입력 객체 CarNames 로 자동차 객체 리스트 생성 메서드
	 * @param names : 유저가 입력한 자동차 리스트 문자열 객체
	 * @return 자동차 리스트 리턴
	 */
	private List<RacingCar> initNameRacingCars(CarNames names) {

		List<RacingCar> racingCars = new ArrayList<>();

		for (CarName name : names.getCarNames()) {

			racingCars.add(new RacingCar(name));
		}

		return racingCars;
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

	/**
	 * 레이싱 결과, 우승자 리턴 메서드
	 * @return : 주행 거리가 가장 큰 차량(중복 허용) 리턴
	 */
	public String getWinnerNames() {

		// 최대 주행거리
		int maxDistance = getMaxDistance();

		// 최대 주행거리 운전자명 집계
		return this.cars.stream()
			.filter(racingCar -> racingCar.getDistance() == maxDistance)
			.map(RacingCar::getCarName)
			.collect(Collectors.joining(", "));
	}

	/**
	 * 차량 리스트 중 주행거리가 가장 큰 수 리턴 메서드
	 * @return : 가장 큰 주행거리 리턴
	 */
	private int getMaxDistance() {

		return this.cars.stream()
			.mapToInt(RacingCar::getDistance)
			.max()
			.orElse(0);
	}
}
