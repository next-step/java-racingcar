package racingCar;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class RacingCarApplication {
	public static void main(String[] args) {
		Game game = new Game(View.inputCarCount(), View.inputMatchCount());
		Cars resultCars = game.start();
	}
}
