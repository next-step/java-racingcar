package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RacingGame {

	private void getUserInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("자동차 대수는 몇 대 인가요?");
		final int CAR_COUNT = Integer.parseInt(br.readLine());

		System.out.println("시도할 횟수는 몇 회 인가요?");
		final int MOVE_COUNT = Integer.parseInt(br.readLine());
	}
}
