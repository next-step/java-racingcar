package racing.domain;

import racing.domain.accelerator.RandomAccelerator;
import racing.view.RacingMonitorView;
import racing.vo.StageOption;

public class GameStageMaker {

	public static Stage create(StageOption option, RacingMonitorView view){

		Stage.StageBuilder builder = Stage.builder(option.getEntrySize(), option.getRoundLimit());

		for(int i = 0; i < option.getEntrySize(); i++) {
			builder.addToEntry("player", new RacingCar(new RandomAccelerator()));
		}

		builder.view(view);

		return builder.build();
	}
}
