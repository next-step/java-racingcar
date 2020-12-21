package racinggame.dto;

import java.util.List;

public class GameResultDto {
	private final String winnerNames;
	private final List<RoundResultDto> gameResult;

	public GameResultDto(String winnerNames, List<RoundResultDto> gameResult) {
		this.winnerNames = winnerNames;
		this.gameResult = gameResult;
	}

	public List<RoundResultDto> getGameResult() {
		return gameResult;
	}

	public String getWinnerNames() {
		return winnerNames;
	}
}
