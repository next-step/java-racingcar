package racing.domain;

import org.junit.jupiter.api.Test;
import racing.domain.accelerator.StaticAccelerator;
import racing.vo.EntryItem;
import racing.vo.RacingRecord;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class EntryTest {

	@Test
	void getWinner(){
		// arrange
		List<EntryItem> items = new ArrayList<>();
		items.add(new EntryItem("A", new RacingCar(new StaticAccelerator(RacingCar.DEFAULT_THRESHOLD))));
		items.add(new EntryItem("B", new RacingCar(new StaticAccelerator(RacingCar.DEFAULT_THRESHOLD -1))));
		Entry entry = new Entry(items);
		entry.drive();

		// action
		List<RacingRecord> winnerRecords = entry.getWinners();

		// assertion
		assertThat(winnerRecords.size()).isEqualTo(1);
	}

}