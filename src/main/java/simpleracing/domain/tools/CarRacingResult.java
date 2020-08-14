package simpleracing.domain.tools;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingResult {
	private List<Records> allRecords;
	private List<Car> winners;

	public CarRacingResult(List<Records> allRecords, List<Car> winners) {
		this.allRecords = allRecords;
		this.winners = winners;
	}

	public String view() {
		return replayRecords() + "\n\n" + viewWinners();
	}

	private String replayRecords() {
		return allRecords.stream()
						 .map(records -> records.viewRecord())
						 .collect(Collectors.joining("\n\n"));
	}

	private String viewWinners() {
		return "우승자는 " + winners.stream()
								.map(winner -> winner.getName())
								.collect(joining(" 와 ")) +
			   "입니다.";
	}
}
