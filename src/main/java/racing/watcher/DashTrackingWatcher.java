package racing.watcher;

import racing.util.ConsolePrinter;
import racing.watcher.events.ChangedPlayerPositionEvent;
import racing.watcher.events.StartedRacingEvent;

import java.util.List;

public class DashTrackingWatcher extends RacingWatcher {

	public static final String EMPTY_NEW_LINE = " ";

	private ConsolePrinter printer;

	public DashTrackingWatcher(ConsolePrinter printer){
		this.printer = printer;
	}

	private void handle(StartedRacingEvent event){
		printer.printMessage("실행 결과");
	}

	private void handle(ChangedPlayerPositionEvent event) {

		List<Integer> currentPositionOfPlayers = event.getPositions();

		currentPositionOfPlayers
				.stream()
				.forEach(position -> printer.printMessage(this.render(position)));

		// 라운드 업데이트 후 공백라인 출력
		printer.printMessage(EMPTY_NEW_LINE);
	}

	private String render(int position) {
		String result = "-";

		// 첫 출발 위치를 표시하기 위해 position이 1보다 큰만큼 점선이 추가되도록 조정
		for(int i = 1; i < position; i++){
			result += "-";
		}

		return result;
	}
}
