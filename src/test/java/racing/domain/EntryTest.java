package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.accelerator.StaticAccelerator;
import racing.vo.RacingRecord;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class EntryTest {

	@DisplayName("레이싱 결과 우승자 반환 테스트")
	@Test
	void getWinner(){
		// arrange
		List<EntryItem> items = new ArrayList<>();
		items.add(new EntryItem("A", new RacingCar(new StaticAccelerator(RacingCar.DEFAULT_THRESHOLD + 1))));
		items.add(new EntryItem("B", new RacingCar(new StaticAccelerator(RacingCar.DEFAULT_THRESHOLD))));

		Entry entry = new Entry(items);
		entry.drive();

		// action
		List<RacingRecord> winnerRecords = entry.getWinners();

		// assertion
		assertThat(winnerRecords.size()).isEqualTo(1);
		assertThat(winnerRecords.get(0).getPlayerName()).isEqualTo("A");
	}


	@DisplayName("레이싱 결과 우승자 반환 테스트, 입력순서와 반대 성적")
	@Test
	void getWinnerWithReversedScore(){
		// arrange
		List<EntryItem> items = new ArrayList<>();
		items.add(new EntryItem("A", new RacingCar(new StaticAccelerator(RacingCar.DEFAULT_THRESHOLD))));
		items.add(new EntryItem("B", new RacingCar(new StaticAccelerator(RacingCar.DEFAULT_THRESHOLD + 1))));

		Entry entry = new Entry(items);
		entry.drive();

		// action
		List<RacingRecord> winnerRecords = entry.getWinners();

		// assertion
		assertThat(winnerRecords.size()).isEqualTo(1);
		assertThat(winnerRecords.get(0).getPlayerName()).isEqualTo("B");
	}

}