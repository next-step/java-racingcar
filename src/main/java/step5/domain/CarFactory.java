package step5.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import step5.util.StringUtil;

public class CarFactory {
	private final static String DELEMETER = ",";
	
	private List<Car> cars;
	public CarFactory(String[] carNamesArray) {
		cars = Arrays.stream(carNamesArray)
				.map(Car::new)
				.collect(Collectors.toList());
	}
	
	public CarFactory(String carNames) {
		if(StringUtil.isEmpty(carNames)) {
			throw new IllegalArgumentException("차 이름을 입력해주세요.");
		}
		new CarFactory(StringUtil.stringSplit(carNames, DELEMETER));
	}
	
	public List<Car> getCars() {
		return cars;
	}
}
