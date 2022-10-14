package study.step5.domain.racinggame;

import study.step5.domain.car.Cars;
import study.step5.domain.exception.BadRequestException;
import study.step5.domain.movestrategy.MoveStrategy;

public class RacingGameInfo {
	private final Cars participants;				// 참가 자동차
	private Cars winners;						// 우승 자동차
	private int maxPosition;					// 최대 이동 거리
	private final int round;						// 게임 라운드 수
	private int currentRound;					// 현재 게임 라운드
	private final MoveStrategy moveStrategy;		// 무브 전략

	public RacingGameInfo(Cars participants, int round, MoveStrategy moveStrategy) {
		validateRound(round);
		this.participants = participants;
		this.maxPosition = 0;
		this.round = round;
		this.currentRound = 0;
		this.moveStrategy = moveStrategy;
	}

	public void setMaxPosition() {
		this.maxPosition = participants.findMaxPosition();
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
		winners = participants.getAllByPosition(this.maxPosition);
		return winners;
	}

	public void printParticipants() {
		participants.forEach(car ->
			System.out.println(car.getName() + " : " + car.getRepeater()));
		System.out.println();
	}

	public void printWinners() {
		winners.forEach(car ->
			System.out.print(car.getName() + ","));
		System.out.println("가 최종 우승했습니다.");
	}
}
