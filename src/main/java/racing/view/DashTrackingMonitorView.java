package racing.view;

import racing.util.MessagePrinter;
import racing.vo.PlayerRecord;

import java.util.List;
import java.util.stream.Collectors;

/**
 * RacingEvent를 전달받아 이벤트 형식에 맞는 방식/내용을 MessagePrinter를 통해 출력
 * 처리하고자 하는 RacingEvent 타입별로 handle 메서드 정의
 */
public class DashTrackingMonitorView implements RacingMonitorView {

	private static final String DASH_SYMBOL = "-";

	private static final String NAME_SEPARATOR = " : ";

	private static final String NAME_JOIN_SEPARATOR = ", ";

	private static final String RESULT_MESSAGE = "%s가 최종 우승했습니다.";

	public static final String EMPTY_NEW_LINE = " ";

	private MessagePrinter printer;


	/**
	 * 메세지 출력 방법을 외부에서 주입받아 사용
	 * @param printer 메세지출력 방법을 구현한 람다함수
	 */
	public DashTrackingMonitorView(MessagePrinter printer){
		this.printer = printer;
	}


	/**
	 * 게임 시작시 전달된 메세지를 출력
	 * @param message 레이싱게임이 시작을 알리는 문자열
	 */
	@Override
	public void renderStart(String message) {
		printer.printMessage(message);
	}


	/**
	 * 게임 진행 중 플레이어위치변경 정보를 받아 각 플레이어 위치를 출력
	 * @param currentPositionOfPlayers currentPositionOfPlayers 플레이어들의 현재 위치정보
	 */
	@Override
	public void renderRound(List<PlayerRecord> currentPositionOfPlayers) {
		currentPositionOfPlayers
				.stream()
				.forEach(record -> printer.printMessage(this.renderPosition(record)));

		// 라운드 업데이트 후 공백라인 출력
		printer.printMessage(EMPTY_NEW_LINE);
	}


	/**
	 * 게임 종료 후 우승자 이름 출력
	 * @param winners 우승자의 기록
	 */
	@Override
	public void renderFinish(List<PlayerRecord> winners) {
		String winnerNames = winners.stream()
				.map(record -> record.getPlayerName())
				.collect(Collectors.joining(NAME_JOIN_SEPARATOR));

		printer.printMessage(String.format(RESULT_MESSAGE, winnerNames));
	}


	private String renderPosition(PlayerRecord record) {
		StringBuilder result = new StringBuilder(record.getPlayerName());
		result.append(NAME_SEPARATOR);
		result.append(DASH_SYMBOL);

		// 첫 출발 위치를 표시하기 위해 position이 1보다 큰만큼 점선이 추가되도록 조정
		for(int i = 1; i < record.getPosition(); i++){
			result.append(DASH_SYMBOL);
		}

		return result.toString();
	}
}
