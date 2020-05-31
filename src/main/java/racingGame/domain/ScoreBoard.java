package racingGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;

public class ScoreBoard {
	private List<Round> round;
	private List<RacingCar> racingCars;
	private List<String> winners;

	public ScoreBoard(String[] carNames, int countOfTime) {
		round = new ArrayList<Round>();
		for (int i = 0; i < countOfTime; i++) {
			round.add(new Round(carNames));
		}
		winners = new ArrayList<String>();
	}

	public void registScore(List<RacingCar> racingCars, int nRound) {
		round.get(nRound).registNRoundScore(racingCars, nRound);
		this.racingCars = racingCars;
	}

	public String[][] makeScoreBoard() {
		int countOfCar = round.get(0).getCarNames().length;
		String[][] scores = new String[countOfCar][round.size()];
		for (int i = 0; i < countOfCar; i++) {
			scores[i] = makeNRoundScoreBoard(i);
		}
		return scores;
	}

	private String[] makeNRoundScoreBoard(int orderOfCar) {
		String[] scores = new String[round.size()];
		for (int j = 0; j < round.size(); j++) {
			scores[j] = round.get(j).getScore()[orderOfCar];
			if (j == 0) {
				scores[j] = (round.get(j).getCarNames()[orderOfCar] + " : " + scores[j]);
			}
		}
		return scores;
	}

	public String getWinner() {
		int winnerPosition = getWinnerPosition();

		for (int i = 0; i < racingCars.size(); i++) {
			registWinner(compareWinnerPosition(winnerPosition, i));
		}

		return winners.stream()
						.map(String::valueOf)
						.collect(Collectors.joining(","));
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
