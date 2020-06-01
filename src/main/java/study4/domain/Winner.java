package study4.domain;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {

	private static final String suffix = "가 최종 우승 했습니다.";

	List<Car> winnerCarList = new ArrayList(); // 자동차 이름만 저장하는 배열
	int max = -1;

	public List<Car> winnerMaxPosition(List<Car> carlist) {

		for (Car car : carlist) {
			max = maxCalculator(car.getPosition());
		}
		winnerListprint(winnerList(max, carlist));

		return winnerCarList;
	}

	// 가장 큰 위치값 구하기
	public int maxCalculator(int maxPosition) {
		if (max < maxPosition) {
			max = maxPosition;
		}
		return max;
	}

	public List<Car> winnerList(int max, List<Car> carlist) {
		for (Car car : carlist) {
			maxcompare(max, car);
		}
		return winnerCarList;
	}

	public int maxcompare(int max, Car car) {
		if (max == car.getPosition()) {
			winnerCarList.add(car);
		}

		return car.getPosition();
	}

	// 결과 출력
	public List<Car> winnerListprint(List<Car> winnerList) {
		if (winnerList.size() == 1) { // winnerList가 1개일때
			System.out.print(winnerList.get(0).getCarName() + suffix);
		}
		if (winnerList.size() != 1) { // winnerList가 2개 이상일 때
			for(Car car : winnerList) {
			System.out.print(String.join(",", car.getCarName()) + suffix);
			}
		}

		return winnerList;
	}
}
