package racing.domain;

import racing.vo.EntryItem;
import racing.vo.RacingRecord;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 게임에 참여한 선수를 관리하는 일급 콜렉션
 */
public class Entry {

	private List<EntryItem> items;

	public Entry(List<EntryItem> items){
		// shallow copy
		this.items = items.stream().collect(Collectors.toList());
	}

	public int size() {
		return items.size();
	}

	public List<RacingRecord> drive() {
		return items.stream()
				.map(entryItem -> {
					entryItem.drive();
					return new RacingRecord(entryItem.getPlayerName(), entryItem.getCarMilieage());
				}).collect(Collectors.toList());
	}

	public List<RacingRecord> getWinners() {

		int longestMileage = items.stream()
				.sorted(Comparator.reverseOrder())
				.findFirst()
				.orElseThrow(IllegalStateException::new)
				.getCarMilieage();

		return items.stream()
				.filter(entryItem -> entryItem.getCarMilieage() >= longestMileage)
				.map(entryItem -> new RacingRecord(entryItem.getPlayerName(), entryItem.getCarMilieage()))
				.collect(Collectors.toList());
	}
}
