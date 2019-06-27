package racing;

import racing.domain.GameStageController;
import racing.view.DashTrackingMonitorView;
import racing.view.ConsoleDialogView;
import racing.view.RacingMonitorView;
import racing.vo.StageOption;

public class RacingGameRunner {

	public static void main(String args[]) {

		StageOption option = ConsoleDialogView.use();
		RacingMonitorView monitorView = new DashTrackingMonitorView(message -> System.out.println(message));
		GameStageController.create(option, monitorView).play();
	}
}
