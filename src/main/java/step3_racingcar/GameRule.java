package step3_racingcar;

import java.util.Random;

import step3_racingcar.view.InputView;
import step3_racingcar.view.ResultView;

public class GameRule {
	private static GameRule gameRule;

	private static final Random random = new Random();
	private final static String ERRMSG_negativeInput = "음수입력은 안됩니다";
	private final static String ERRMSG_numberFormat = "숫자를 입력하세요";


	public GameRule() {
	}

	public static GameRule getInstance(){
		if(gameRule == null)
		{
			gameRule = new GameRule();
		}

		return gameRule;
	}
	public int isAcceptableValue(String inputValue)
	{
		try
		{
			int value = Integer.parseInt(inputValue);

			if(value < 0 )
			{
				throw new RuntimeException(ERRMSG_negativeInput);
			}

			return value;

		}catch (NumberFormatException e)
		{
			throw new RuntimeException(ERRMSG_numberFormat);
		}
	}


	public boolean isCarMoving() {
		int randomValue = random.nextInt(10);
		return randomValue >= 4;
	}

}
