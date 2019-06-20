package racing.domain;

import racing.vo.EntryItem;
import racing.vo.RacingRecord;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 게임에 참여한 선수를 관리하는 일급 콜렉션
 */
public class Entry {

	private List<EntryItem> players;

	public Entry(List<EntryItem> players){
		// shallow copy
		this.players = players.stream().collect(Collectors.toList());
	}

	public int size() {
		return players.size();
	}

	public List<RacingRecord> drive() {
		return players.stream()
				.map(entryItem -> {
					entryItem.drive();
					return new RacingRecord(entryItem.getPlayerName(), entryItem.getCarMilieage());
				}).collect(Collectors.toList());
	}

	public List<RacingRecord> getWinners() {
		return null;
	}
}
