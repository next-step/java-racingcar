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

		List<String> messageFormView = new ArrayList<>();
		RacingMonitorView view = new DashTrackingMonitorView(message -> messageFormView.add(message));
		builder.view(view);

		Stage stage = builder.build();

		// Action
		stage.play();

		/**
		 * 플레이어 위치변경 이벤트에 전체 참가자 숫자만큼 정보가 전달되는지 확인
		 * 고민 : RacingMonitorView 의 구현클래스를 사용해서 State 동작을 테스트하니 검증 구문이 구현클래스에 종속되는 문제
		 */
		// Assertion
		assertThat(messageFormView.size()).isEqualTo(4); // 시작 1회, 이동 2회(차가 2대), 라운드 종료 1회
		assertThat(messageFormView.get(1)).isEqualTo("player1:-");
		assertThat(messageFormView.get(2)).isEqualTo("player2:-");


	}

}