package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
	List<GameStatus> gameStatusList = new ArrayList<>();

	public void addResult(GameStatus gameStatus) {
		gameStatusList.add(gameStatus);
	}

	public List<GameStatus> getGameResultList() {
		return gameStatusList;
	}

	public List<String> getGameWinners() {
		int gameCount = gameStatusList.size() - 1;
		GameStatus lastGameStatus = gameStatusList.get(gameCount);
		GameWinners gameWinners = new GameWinners(lastGameStatus);
		return gameWinners.getWinners();
	}
}
