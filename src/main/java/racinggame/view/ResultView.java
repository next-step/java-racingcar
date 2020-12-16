package racinggame.view;

import racinggame.dto.GameResultDto;
import racinggame.dto.MoveResultDto;
import racinggame.dto.RoundResultDto;

public class ResultView {
	public String getCarPositionUi(int position) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

	public void printWinnerNames(GameResultDto gameResultDto) {
		System.out.println(gameResultDto.getWinnerNames() + "가 최종 우승했습니다.");
	}

	private void printRoundResult(RoundResultDto roundResultDto) {
		for (MoveResultDto moveResultDto : roundResultDto.getRoundResult()) {
			System.out.println(moveResultDto.getName() + " : " + getCarPositionUi(moveResultDto.getPosition()));
		}
	}

	public void printGameResult(GameResultDto gameResultDto) {
		System.out.println("실행 결과");
		for (RoundResultDto roundResultDto : gameResultDto.getGameResult()) {
			printRoundResult(roundResultDto);
			System.out.println();
		}
	}
}
