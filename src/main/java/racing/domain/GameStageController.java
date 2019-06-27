package racing.domain;

import racing.domain.accelerator.RandomAccelerator;
import racing.view.RacingMonitorView;
import racing.vo.StageOption;

/**
 * 옵션을 받아 게임(컨트롤러)을 생성하고 뷰를 주입받아 제어하는 컨트롤러
 */
public class GameStageController {

	public static Stage create(StageOption option, RacingMonitorView view){

		Stage.StageBuilder builder = Stage.builder(option.getEntrySize(), option.getRoundLimit());

		for(int i = 0; i < option.getEntrySize(); i++) {
			builder.addToEntry(option.getPlayerName(i), new RacingCar(new RandomAccelerator()));
		}

		return builder.build();
	}
}
