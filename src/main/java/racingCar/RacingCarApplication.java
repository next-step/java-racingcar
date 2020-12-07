package racingCar;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class RacingCarApplication {
	public static void main(String[] args) {
		int carCount = View.inputCarCount();
		Game game = new Game(carCount);
	}
}
