package study.step4;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameInfo {
	private List<Car> participants;		// 참가 자동차
	private List<Car> winners;			// 우승 자동차
	private int maxPosition;			// 최대 이동 거리
	private int round;					// 게임 라운드 수
	private int currentRound;			// 현재 게임 라운드

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

	public void setParticipants(List<Car> participants) {
		this.participants = participants;
	}

	public List<Car> getParticipants() {
		return this.participants;
	}

	// car 의 위치가 maxPosition 과 같은 경우 true 반환
	public boolean isWinners(Car car) {
		return car.getPosition() == this.maxPosition;
	}

	public List<Car> findWinners() {
		this.winners = this.participants.stream()
			.filter(this::isWinners)
			.collect(Collectors.toList());
		return this.winners;
	}

	public void printWinners() {
		System.out.print(winners.stream()
			.map(Car::getName)
			.collect(Collectors.joining(", ")));
		System.out.println("가 최종 우승했습니다.");
	}
}
