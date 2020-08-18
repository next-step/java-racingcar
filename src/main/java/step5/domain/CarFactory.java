package step5.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import step5.util.StringUtil;

public class CarFactory {
	public final static String DELEMETER = ",";

	public static List<Car> create(String carName) {
		if (StringUtil.isEmpty(carName)) {
			throw new IllegalArgumentException("차 이름을 입력해주세요.");
		}
		String[] carNamesArray= StringUtil.stringSplit(carName,DELEMETER);
		return createCarWithArray(carNamesArray);
	}

	public static List<Car> createCarWithArray(String[] carNameArray) {
		return Arrays.stream(carNameArray)
				.map(Car::new)
				.collect(Collectors.toList());
	}
}
