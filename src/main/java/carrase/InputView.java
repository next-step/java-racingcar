package carrase;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
	public static final String INTRO_MESSAGE_FOR_GET_GAME_COUNT = "시도할 회수는 몇 회 인가요?";
	public static final String INTRO_MESSAGE_FOR_GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

	public void drawQuestionOfCarNames() {
		System.out.println(INTRO_MESSAGE_FOR_GET_CAR_NAMES);
	}

	public List<String> getCarNames() {
		Scanner sc =  new Scanner(System.in);
		String inputName = sc.nextLine();
		String[] names = inputName.split(",");
		return Arrays.asList(names);
	}

	public void drawQuestionOfGameCount() {
		System.out.println(INTRO_MESSAGE_FOR_GET_GAME_COUNT);
	}

	public int getGameCount() {
		Scanner sc =  new Scanner(System.in);
		return sc.nextInt();
	}
}
