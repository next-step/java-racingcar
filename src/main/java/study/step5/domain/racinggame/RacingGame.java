package study.step5.domain.racinggame;

import study.step5.domain.car.Cars;
import study.step5.exception.BadRequestException;
import study.step5.domain.movestrategy.MoveStrategy;

public class RacingGame {
	private final Cars participants;				// 참가 자동차
	private final int round;						// 게임 라운드 수
	private int currentRound;					// 현재 게임 라운드
	private final MoveStrategy moveStrategy;		// 무브 전략

	public RacingGame(Cars participants, int round, MoveStrategy moveStrategy) {
		validateRound(round);
		this.participants = participants;
		this.round = round;
		this.currentRound = 0;
		this.moveStrategy = moveStrategy;
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

	public static void validateRound(int round) {
		if (round < 0) {
			throw new BadRequestException("음수는 입력할 수 없습니다.");
		}
	}

	public Cars getParticipants() {
		return this.participants;
	}

	public MoveStrategy getMoveStrategy() {
		return this.moveStrategy;
	}

	public Cars findWinners() {
		return participants.getAllByPosition(participants.findMaxPosition());
	}
}
