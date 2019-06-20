package racing.view;

import racing.util.MessagePrinter;
import racing.view.events.ChangedPlayerPositionEvent;
import racing.view.events.StartedRacingEvent;
import racing.vo.RacingRecord;

import java.util.List;

/**
 * RacingEvent를 전달받아 이벤트 형식에 맞는 방식/내용을 MessagePrinter를 통해 출력
 * 처리하고자 하는 RacingEvent 타입별로 handle 메서드 정의
 */
public class DashTrackingMonitorView extends RacingMonitorView {

	private static final String DASH_SYMBOL = "-";

	private static final String NAME_SEPARATOR = " : ";

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
	 * 게임 시작 이벤트에 전달된 메세지를 출력
	 * @param event 레이싱게임이 시작 될 때 발생하는 이벤트
	 */
	private void handle(StartedRacingEvent event){
		printer.printMessage(event.getMessage());
	}

	/**
	 * 게임 진행 중 플레이어위치변경 이벤트를 받아 각 플레이어 위치를 출력
	 * @param event 레이싱게임 라운드가 실행 될 때마다 발생하는 이벤트, 각 플레이어들의 현재 위치정보 포함
	 */
	private void handle(ChangedPlayerPositionEvent event) {

		List<RacingRecord> currentPositionOfPlayers = event.getPositions();

		currentPositionOfPlayers
				.stream()
				.forEach(record -> printer.printMessage(this.renderPosition(record)));

		// 라운드 업데이트 후 공백라인 출력
		printer.printMessage(EMPTY_NEW_LINE);
	}

	private String renderPosition(RacingRecord record) {
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
