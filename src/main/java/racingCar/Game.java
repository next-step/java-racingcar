package racingCar;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class Game {
	private static int carCount;

	public Game(int carCount) {
		validateCarCount(carCount);
		this.carCount = carCount;
	}

	private void validateCarCount(int carCount) {
		if(carCount < 1) throw new IllegalArgumentException("자동차 수는 1보다 작을 수 없습니다.");
	}

	public int getCarCount() {
		return carCount;
	}
}
