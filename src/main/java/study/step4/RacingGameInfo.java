package study.step4;

public class RacingGameInfo {
	private Cars participants;			// 참가 자동차
	private Cars winners;				// 우승 자동차
	private int maxPosition;			// 최대 이동 거리
	private int round;					// 게임 라운드 수
	private int currentRound;			// 현재 게임 라운드
	private MoveStrategy moveStrategy;

	public RacingGameInfo() {}

	public void initRacingGameInfo() {
		this.maxPosition = 0;
		this.currentRound = 0;
	}

	public void setMaxPosition(int maxPosition) {
		this.maxPosition = maxPosition;
	}

	public int getMaxPosition() {
		return this.maxPosition;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getRound() {
		return this.round;
	}

	public void addCurrentRound() {
		this.currentRound++;
	}

	public int getCurrentRound() {
		return this.currentRound;
	}

	public void setParticipants(Cars participants) {
		this.participants = participants;
	}

	public Cars getParticipants() {
		return this.participants;
	}

	public void setMoveStrategy(MoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}

	public MoveStrategy getMoveStrategy() {
		return this.moveStrategy;
	}

	public Cars findWinners() {
		this.winners = this.participants.getAllByPosition(this.maxPosition);
		return this.winners;
	}

	public void printWinners() {
		winners.printName();
		System.out.println("가 최종 우승했습니다.");
	}
}
