package racinggame;

import racinggame.car.CarDTO;
import racinggame.car.CarGroup;
import racinggame.rule.RacingGameRule;

import java.util.List;

/**
 * Created by hspark on 02/11/2018.
 */
public class RacingGame {

	private RacingGameRule gameRule;
	private CarGroup carGroup;
	private int tryCount;

	public RacingGame(String[] carNames, int tryCount, RacingGameRule gameRule) {
		this.carGroup = new CarGroup(carNames);
		this.tryCount = tryCount;
		this.gameRule = gameRule;
	}

	public void move() {
		reduceTryCount();
		carGroup.moveForward(gameRule);
	}

	private void reduceTryCount() {
		tryCount -= 1;
	}

	public List<CarDTO> getCarDtoList() {
		return carGroup.getCarDTOList();
	}

	public boolean hasNextGame() {
		return tryCount > 0;
	}

	public RacingGameResult getGameResult() {
		return new RacingGameResult(carGroup.getCarDTOList());
	}

}
