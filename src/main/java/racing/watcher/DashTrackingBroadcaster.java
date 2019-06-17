package racing.watcher;

import racing.watcher.events.ChangedPlayerPositionEvent;
import racing.watcher.events.StartedRacingEvent;

import java.util.List;

public class DashTrackingBroadcaster extends RacingWatcher {


	private void handle(StartedRacingEvent event){
		System.out.println();
		System.out.println("실행 결과");
	}

	private void handle(ChangedPlayerPositionEvent event) {

		List<Integer> currentPositionOfPlayers = event.getPositions();

		currentPositionOfPlayers
				.stream()
				.forEach(position -> System.out.println(this.render(position)));

		// 라운드 업데이트 후 공백라인 출력
		System.out.println();
	}

	private String render(int position) {
		String result = "";
		for(int i = 0; i < position; i++){
			result += "-";
		}

		return result;
	}
}
