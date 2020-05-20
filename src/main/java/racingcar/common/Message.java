package racingcar.common;

public class Message {
	private Message() {
		throw new IllegalStateException("Utility class");
	}
	public final static String CAR_QUESTION_MSG = "자동차 댓수는 몇대인가요?";
	public final static String GAME_TRY_QUESTION_MSG = "게임을 시도할 회수는 몇 회 인가요?";
	public final static String SUCCESS_MAKE_CAR_MSG = "자동차 생성이 완료 되었습니다.";
	public final static String FAIL_MAKE_CAR_MSG = "자동차 생성이 실패 되었습니다.";
	public final static String GAME_END_MSG = "게임 종료";
	public final static String GAME_START_MSG = "게임 시작";
	public final static String PLAY_START_MSG = "회차 시작";
	public final static String PLAY_END_MSG = "회차 종료";
}
