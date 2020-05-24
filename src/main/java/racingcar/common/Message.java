package racingcar.common;

public class Message {
	private Message() {
		throw new UnsupportedOperationException("Utility class");
	}
	public final static String CAR_QUESTION_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	public final static String GAME_TRY_QUESTION_MSG = "게임을 시도할 회수는 몇 회 인가요?";
	public final static String SUCCESS_MAKE_CAR_MSG = "자동차 생성이 완료 되었습니다.";
	public final static String FAIL_MAKE_CAR_MSG = "자동차 생성이 실패 되었습니다.";
	public final static String GAME_END_MSG = "게임 종료";
	public final static String GAME_START_MSG = "게임 시작";
	public final static String PLAY_START_MSG = "회차 시작";
	public final static String PLAY_END_MSG = "회차 종료";
	public final static String WINNER_MSG = "가 최종 우승했습니다.";

}
