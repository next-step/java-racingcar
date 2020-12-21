package racinggame.dto;

import java.util.List;

public class RoundResultDto {
	private List<MoveResultDto> roundResult;

	public RoundResultDto(List<MoveResultDto> roundResult) {
		this.roundResult = roundResult;
	}

	public List<MoveResultDto> getRoundResult() {
		return roundResult;
	}
}
