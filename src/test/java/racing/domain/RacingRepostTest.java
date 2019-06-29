package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.accelerator.StaticAccelerator;
import racing.vo.PlayerRecord;
import racing.vo.RacingReport;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RacingRepostTest {

	@DisplayName("레이싱 결과 우승자 반환 테스트")
	@Test
	void getWinner(){
		// arrange
		List<PlayerRecord> records = new ArrayList<>();
		records.add(new PlayerRecord("A", 5));
		records.add(new PlayerRecord("B", 3));

		RacingReport report = new RacingReport(records, 0);

		// action
		List<PlayerRecord> winnerRecords = report.getWinners();

		// assertion
		assertThat(winnerRecords.size()).isEqualTo(1);
		assertThat(winnerRecords.get(0).getPlayerName()).isEqualTo("A");
	}


	@DisplayName("레이싱 결과 우승자 반환 테스트, 입력순서와 반대 성적")
	@Test
	void getWinnerWithReversedScore(){
		// arrange
		List<PlayerRecord> records = new ArrayList<>();
		records.add(new PlayerRecord("A", 3));
		records.add(new PlayerRecord("B", 4));

		RacingReport report = new RacingReport(records, 0);

		// action
		List<PlayerRecord> winnerRecords = report.getWinners();

		// assertion
		assertThat(winnerRecords.size()).isEqualTo(1);
		assertThat(winnerRecords.get(0).getPlayerName()).isEqualTo("B");
	}


	@DisplayName("레이싱 결과 우승자 반환 테스트, 같은 성정")
	@Test
	void getWinnerWithSameScore() {
		// arrange
		List<PlayerRecord> records = new ArrayList<>();
		records.add(new PlayerRecord("A", 5));
		records.add(new PlayerRecord("B", 3));
		records.add(new PlayerRecord("C", 5));

		RacingReport report = new RacingReport(records, 0);

		// action
		List<PlayerRecord> winnerRecords = report.getWinners();

		// assertion
		assertThat(winnerRecords.size()).isEqualTo(2);
		assertThat(winnerRecords.get(0).getPlayerName()).isIn(new String[]{"A", "C"});
		assertThat(winnerRecords.get(1).getPlayerName()).isIn(new String[]{"A", "C"});
	}
}