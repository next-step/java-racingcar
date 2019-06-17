package racing.watcher;

import java.util.List;

public class DashTrackingBroadcaster implements RacingWatcher {

	@Override
	public void update(List<Integer> currentPositionOfPlayers) {

		currentPositionOfPlayers
				.stream()
				.forEach(position -> System.out.println(this.render(position)));

		// 라운드 업데이트 후 공백라인 출력
		System.out.println("");
	}

	private String render(int position) {
		String result = "";
		for(int i = 0; i < position; i++){
			result += "-";
		}

		return result;
	}
}
