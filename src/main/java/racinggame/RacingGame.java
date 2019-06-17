package racinggame;

import racinggame.view.InputView;

import java.util.Scanner;

public class RacingGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// return 결과값으로 객체 생성 갯수 구함
		int carCount = InputView.input(sc,"자동차 대수는 몇 대 인가요?");
		// return 결과값으로 횟수 구함(time) - car 객체를 만들어서 횟수를 카운트 할것인지? 진행하는 클래스를 만들어서 그 클래스가 횟수를 카운트할지
		int t = InputView.input(sc,"시도할 회수는 몇 회 인가요?");
	}

	private int time;
	private int[] carPositions = {0, 0, 0};

	public int[] move() {
		return carPositions;
	}

}
