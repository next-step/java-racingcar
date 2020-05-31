package racingGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoard {
	private List<Round> round;
	private List<RacingCar> racingCars;
	private List<String> winners;

	public ScoreBoard(String[] carNames, int countOfTime) {
		this.round = new ArrayList<Round>();
		for (int i = 0; i < countOfTime; i++) {
			round.add(new Round(carNames));
		}
		this.winners = new ArrayList<String>();
	}

	public void registScore(RacingCar racingCar, int nRound) {
		round.get(nRound).registNRoundScore(racingCar, nRound);
	}

	public String[][] makeScoreBoard() {
		int countOfCar = round.get(0).getCarNames().size();
		String[][] scores = new String[countOfCar][round.size()];
		for (int i = 0; i < countOfCar; i++) {
			scores[i] = makeNRoundScoreBoard(i);
		}
		return scores;
	}

	private String[] makeNRoundScoreBoard(int orderOfCar) {
		String[] scores = new String[round.size()];
		for (int j = 0; j < round.size(); j++) {
			scores[j] = round.get(j).getScore().get(orderOfCar);
			if (j == 0) {
				scores[j] = (round.get(j).getCarNames().get(orderOfCar) + " : " + scores[j]);
			}
		}
		return scores;
	}

	public String getWinner() {
		return winners.stream()
						.map(String::valueOf)
						.collect(Collectors.joining(","));
	}

	public ScoreBoard registWinners(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
		int winnerPosition = getWinnerPosition();
		
		for (int i = 0; i < racingCars.size(); i++) {
			String winner = compareWinnerPosition(winnerPosition, i);
			registWinner(winner);
		}
		return this;
	}

	private void registWinner(String winner) {
		if (!winner.isEmpty()) {
			winners.add(winner);
		}
	}

	private String compareWinnerPosition(int winnerPosition, int orderOfCar) {
		if (racingCars.get(orderOfCar).getCountOfPosition() == winnerPosition) {
			return racingCars.get(orderOfCar).getCarName();
		}
		return "";
	}

	private int getWinnerPosition() {
		int winnerPosition = 0;
		for (int i = 0; i < racingCars.size(); i++) {
			int targetPosition = racingCars.get(i).getCountOfPosition();
			winnerPosition = registWinnerPosition(winnerPosition, targetPosition);
		}
		return winnerPosition;
	}

	private int registWinnerPosition(int winnerPosition, int targetPosition) {
		return (winnerPosition < targetPosition) ? targetPosition : winnerPosition;
	}
}
