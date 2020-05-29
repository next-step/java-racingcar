package study4;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {

	private static final String suffix = "가 최종 우승 했습니다.";

	List<String> winnerCarList = new ArrayList();
	int max = -1;

	public List<String> winnerMaxPosition(List<Car> carlist) {
		for (int i = 0; i < carlist.size(); i++) {
			max = maxCalculator(carlist.get(i).getPosition());
		}
		winnerListprint(winnerList(max, carlist));

		return winnerCarList;
	}

	public List<String> winnerList(int max, List<Car> carlist) {
		for (int i = 0; i < carlist.size(); i++) {
			maxcompare(max, carlist.get(i).getPosition(), carlist.get(i).getCarName());
		}
		return winnerCarList;
	}

	public int maxcompare(int max, int carPosition, String carName) {
		if (max == carPosition) {
			winnerCarList.add(carName);

		}

		return carPosition;
	}

	// 가장 큰 위치값 구하기
	public int maxCalculator(int maxPosition) {
		if (max < maxPosition) {
			max = maxPosition;
		}
		return max;
	}

	// 결과 출력
	public List<String> winnerListprint(List<String> winnerList) {
		if (winnerList.size() == 1) { // winnerList가 1개일때
			System.out.print(winnerList.get(0) + suffix);
		}
		if (winnerList.size() != 1) { // winnerList가 2개 이상일 때
			System.out.print(String.join(",", winnerList) + suffix);
		}

		return winnerList;
	}
}
