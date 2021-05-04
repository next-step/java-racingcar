package domain;

import java.util.ArrayList;
import java.util.List;

import util.InputView;

public class RacingcarList {
	private static final List<Racingcar> racingcarList = new ArrayList<>();
	private static final List<String> winnerList = new ArrayList<>();
	private static int maxPosition;

	public static List<Racingcar> getRacingcarStringToList(String racingcarListString) {
		String[] racingcarArray = racingcarListString.split(",");
		for (String racingcar : racingcarArray) {
			Racingcar car = new Racingcar(racingcar);
			racingcarList.add(car);
		}
		return racingcarList;
	}

	public static List<String> getWinner(List<Racingcar> carList) {
		carList.sort((a, b) -> b.getCarPosition().length() - a.getCarPosition().length());
		maxPosition = carList.get(0).getCarPosition().length();
		for (Racingcar racingcar : carList) {
			comparePosition(racingcar);
		}
		return winnerList;
	}

	public static void comparePosition(Racingcar racingcar) {
		if (racingcar.getCarPosition().length() == maxPosition) {
			winnerList.add(racingcar.getCarName());
		}
	}

	public static void printRaceResult(List<Racingcar> racingcarList, String repeatTime) {
		InputView.getRaceResult();
		for (int i = 0; i < Integer.parseInt(repeatTime); i++) {
			printEachStage(racingcarList);
		}
		List<String> winnerList = RacingcarList.getWinner(racingcarList);
		System.out.println(String.join(", ", winnerList) + "이(가) 최종 우승했습니다.");
	}

	public static void printEachStage(List<Racingcar> racingcarList) {
		for (Racingcar racingcar : racingcarList) {
			racingcar.setPosition();
			System.out.println(racingcar.getCarName() + " : " + racingcar.getCarPosition());
		}
		System.out.println();
	}
}
