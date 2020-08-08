package racingWinner;

import java.util.ArrayList;
import java.util.List;

public class MakeCar {
	
	private final static int STRING_MAX_LENGTH = 5;
	//카 글자수 테스트
	public static boolean checkMaxLength(String name) {
		if(name.length() <= STRING_MAX_LENGTH) {
			return true;
		}
		return false;
	}
	
	//카 배열 글자수 테스트
	public static boolean makeCarsCondition(String[] carNamesArray) {
		boolean flag = true;
		for(int i = 0; i < carNamesArray.length; i++) {
			//모두 true면 true, 하나라도 false면 false
			flag = flag && checkMaxLength(carNamesArray[i]);
		}
		return flag;
	}
	
	//카 클래스 생성
	public static Car makeCar(String name) {
		Car car = new Car();
		car.setCarName(name);
		return car;
	}
	
	//카 리스트 생성
	public static List<Car> makeCars(String[] carNamesArray) {
		List<Car> cars = new ArrayList<Car>();
		for(int i = 0; i < carNamesArray.length; i++) {
			Car car = makeCar(carNamesArray[i]);
			cars.add(car);
		}
		return cars;
	}

}
