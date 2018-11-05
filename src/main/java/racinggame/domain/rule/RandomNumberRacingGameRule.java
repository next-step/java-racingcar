package racinggame.domain.rule;

import racinggame.domain.car.Car;

import java.util.Random;

/**
 * Created by hspark on 03/11/2018.
 */
public class RandomNumberRacingGameRule implements RacingGameRule {
	private static final Random random = new Random();
	private static final int STANDARD_SCORE = 5;
	private static final int MAX_SCORE = 9;

	// 랜덤 숫자 게임 룰은 자동차의 상태를 사용하지 않는다.
	@Override
	public boolean isAvailableMoving(Car car) {
		return random.nextInt(MAX_SCORE + 1) > STANDARD_SCORE;
	}
}
