package racingCar;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class Car {
	private static int position;
	private static final int MOVABLE_MINIMUM_VALUE = 4;

	public Car() {
		position = 0;
	}

	public int move(int arg) {
		if(isMovable(arg)){
			return position+1;
		}
		return position;
	}

	private boolean isMovable(int arg) {
		return arg >= MOVABLE_MINIMUM_VALUE;
	}
}
