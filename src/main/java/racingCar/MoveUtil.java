package racingCar;

import java.util.Random;

/**
 * @author : byungkyu
 * @date : 2020/12/10
 * @description :
 **/
public class MoveUtil implements RandomMove{

	@Override
	public int move() {
		Random random = new Random();
		return random.nextInt(10);
	}
}
