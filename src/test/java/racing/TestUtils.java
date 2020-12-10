package racing;

import racing.car.CarName;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

	private TestUtils() {
	}

	public static List<CarName> createAnyCarNameList(int carNum) {
		List<CarName> carNameList = new ArrayList<>();
		for (int i = 0; i < carNum; i++) {
			char c = (char) (48 + i);
			CarName carName = new CarName(String.format("%c%c%c", c, c, c));
			carNameList.add(carName);
		}
		return carNameList;
	}

	public static Counter createCounter() {
		return new Counter();
	}


	public static class Counter {
		private int count;

		Counter() {
			count = 0;
		}

		public void addCount() {
			count++;
		}

		public int getCount() {
			return count;
		}
	}
}
