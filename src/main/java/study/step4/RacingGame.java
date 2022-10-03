package study.step4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
	private static final int STANDARD = 4;
	private static final Random RANDOM = new Random();
	private static final int BOUND = 10;
	private static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		RacingGameInfo racingGameInfo = new RacingGameInfo();
		racingGameInfo.initRacingGameInfo();

		// 자동차 이름을 입력받는 부분
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String input = SCANNER.next();

		String[] names = splitCarNames(input);
		ArrayList<Car> participants = registerParticipants(names);
		racingGameInfo.setParticipants(participants);

		// 시도할 회수를 입력받는 부분
		System.out.println("시도할 회수는 몇회인가요?");
		int round = SCANNER.nextInt();
		if (round < 0) {
			throw new BadRequestException("음수는 입력할 수 없습니다.");
		}
		racingGameInfo.setRound(round);

		// 시도할 횟수만큼 레이싱 게임 실행
		System.out.println("실행결과");
		while (racingGameInfo.getCurrentRound() < racingGameInfo.getRound()) {
			startRound(racingGameInfo);
			racingGameInfo.addCurrentRound();
		}

		// 우승자 조회
		racingGameInfo.findWinners();
		racingGameInfo.printWinners();
	}

	public static String[] splitCarNames(String input) {
		return input.split(",");
	}

	public static ArrayList<Car> registerParticipants(String[] names) {
		ArrayList<Car> participants = new ArrayList<>();
		for (String name : names) {
			Car car = new Car();
			car.setName(name);
			car.initPosition();
			participants.add(car);
		}
		return participants;
	}

	public static boolean isGoForward(int random) {
		return random >= STANDARD;
	}

	public static void startRound(RacingGameInfo racingGameInfo) {
		ArrayList<Car> participants = racingGameInfo.getParticipants();
		int maxPosition = 0;

		for (int i = 0; i < participants.size(); i++) {
			Car car = proceedCar(participants.get(i));
			// 게임을 진행 후에 최대 위치를 계산
			maxPosition = Math.max(maxPosition, car.getPosition());
			car.printName();
			car.printPosition();
		}
		System.out.println();
		racingGameInfo.setMaxPosition(maxPosition);
	}

	public static Car proceedCar(Car car) {
		if (isGoForward(RANDOM.nextInt(BOUND))) {
			car.move();
		}
		return car;
	}
}
