package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.RacingCar;
import racing.domain.Stage;
import racing.domain.accelerator.DriveAccelerator;
import racing.domain.accelerator.StaticAccelerator;
import racing.view.DashTrackingMonitorView;
import racing.view.RacingMonitorView;
import racing.view.events.ChangedPlayerPositionEvent;
import racing.vo.RacingRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class StageTest {

	@DisplayName("게임 생성 테스트")
	@ParameterizedTest
	@CsvSource({"1,5", "3,2"})
	void createGame(int entrySize, int round){

		// Arrange
		Stage.StageBuilder builder = Stage.builder(entrySize, round);

		IntStream.range(0, entrySize)
				.forEach((index) -> builder.addToEntry("player" + index, new RacingCar(new StaticAccelerator(5))));

		// Action
		Stage stage = builder.build();

		/**
		 * 고민 : getCountOfPlayers, getRemainingRounds 메서드는 테스트 검증목적으로만 사용되고 프로덕션 코드에서는 사용하지 않는다.
		 */
		// Assertion
		assertThat(stage.getCountOfPlayers()).isEqualTo(entrySize);
		assertThat(stage.getRemainingRounds()).isEqualTo(round);
	}


	@Test
	@DisplayName("게임 중계 시스템 적용 테스트")
	void updateView(){

		// Arrange
		int roundLimit = 1;
		int acceleratorAmount = 5;

		DriveAccelerator accelerator = new StaticAccelerator(acceleratorAmount);
		Stage.StageBuilder builder = Stage.builder(2, roundLimit);
		builder.addToEntry("player1", new RacingCar(accelerator));
		builder.addToEntry("player2", new RacingCar(accelerator));

		Stage stage = builder.build();

		// Action
		List<RacingRecord> records = stage.play();

		// Assertion
		assertThat(records.size()).isEqualTo(2);
		assertThat(records.get(0).getPlayerName()).isEqualTo("player1");
		assertThat(records.get(0).getPosition()).isEqualTo(1);

		assertThat(records.get(1).getPlayerName()).isEqualTo("player2");
		assertThat(records.get(1).getPosition()).isEqualTo(1);
	}

}