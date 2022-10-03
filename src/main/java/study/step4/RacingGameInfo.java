package study.step4;

import java.util.ArrayList;

public class RacingGameInfo {
	private ArrayList<Car> participants;	// 참가 자동차
	private ArrayList<Car> winners;			// 우승 자동차
	private int maxPosition;				// 최대 이동 거리
	private int round;						// 게임 라운드 수
	private int currentRound;				// 현재 게임 라운드

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

	public void setParticipants(ArrayList<Car> participants) {
		this.participants = participants;
	}

	public ArrayList<Car> getParticipants() {
		return this.participants;
	}

	public ArrayList<Car> findWinners() {
		ArrayList<Car> winners = new ArrayList<>(); ;

		ArrayList<Car> participants = this.getParticipants();
		int maxPosition = this.getMaxPosition();

		for (int i = 0; i < participants.size(); i++) {
			if (participants.get(i).getPosition() == maxPosition) {
				winners.add(participants.get(i));
			}
		}
		this.winners = winners;
		return this.winners;
	}

	public void printWinners() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < this.winners.size(); i++) {
			if (i == this.winners.size() - 1) {
				result.append(this.winners.get(i).getName() + "가 최종 우승했습니다.");
				break;
			}
			result.append(this.winners.get(i).getName() + ", ");
		}
		System.out.println(result);
	}
}
