package racing.domain.accelerator;

import java.util.Random;

/**
 * 무작위 가속 가중치값을 반환하는 가속기
 */
public class RandomAccelerator implements DriveAccelerator {

	private static final int MAX_AMOUNT = 10;

	private Random amountGenerator = new Random();

	@Override
	public int getAmount() {
		return amountGenerator.nextInt(MAX_AMOUNT);
	}
}
