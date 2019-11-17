package step3.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String[] getParticipantNames() throws IOException {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)");
		String[] participantNames = br.readLine().split(",");

		if (participantNames.length < 2) {
			throw new IllegalArgumentException();
		}

		return participantNames;
	}

	public static int getTurnCount() throws IOException {
		System.out.println("시도할 회수는 몇회인가요?");
		int turnCount = Integer.parseInt(br.readLine());

		if (turnCount < 1) {
			throw new IllegalArgumentException();
		}

		return turnCount;
	}
}
