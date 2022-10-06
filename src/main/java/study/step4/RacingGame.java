package study.step4;

import java.util.Scanner;

public class RacingGame {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String SEPARATOR = ",";
	private static final RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

	public static void main(String[] args) {
		RacingGameInfo racingGameInfo = new RacingGameInfo();
		racingGameInfo.initRacingGameInfo();

		String[] names = getNames();
		racingGameInfo.setParticipants(registerParticipants(names));

		racingGameInfo.setRound(getRound());
		racingGameInfo.setMoveStrategy(randomMoveStrategy);

		start(racingGameInfo);
		end(racingGameInfo);
	}

	public static String[] getNames () {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String input = SCANNER.next();
		return split(input);
	}

	public static String[] split (String input) {
		return input.split(SEPARATOR);
	}

	public static int getRound () {
		System.out.println("시도할 회수는 몇회인가요?");
		int round = SCANNER.nextInt();
		validateRound(round);
		return round;
	}

	public static void validateRound (int round) {
		if (round < 0) {
			throw new BadRequestException("음수는 입력할 수 없습니다.");
		}
	}

	public static Cars registerParticipants(String[] names) {
		Cars participants = new Cars();
		for (String name : names) {
			Car car = new Car();
			car.setName(name);
			car.initPosition();
			participants.add(car);
		}
		return participants;
	}

	public static void start(RacingGameInfo racingGameInfo) {
		System.out.println("실행결과");
		while (racingGameInfo.getCurrentRound() < racingGameInfo.getRound()) {
			playRound(racingGameInfo);
			racingGameInfo.addCurrentRound();
		}
	}

	public static void playRound(RacingGameInfo racingGameInfo) {
		Cars participants = racingGameInfo.getParticipants();
		participants.moveAll(racingGameInfo.getMoveStrategy());

		int maxPosition = participants.findMaxPosition();
		racingGameInfo.setMaxPosition(maxPosition);

		participants.printAll();
		System.out.println();
	}

	public static void end(RacingGameInfo racingGameInfo) {
		// 우승자 조회
		racingGameInfo.findWinners();
		racingGameInfo.printWinners();
	}
}
