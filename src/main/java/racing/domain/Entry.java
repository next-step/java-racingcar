package racing.domain;

import racing.vo.EntrySlot;
import racing.vo.RacingRecord;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 게임에 참여한 선수를 관리하는 일급 콜렉션
 */
public class Entry {

	private List<EntrySlot> players;

	public Entry(List<EntrySlot> players){
		// shallow copy
		this.players = players.stream().collect(Collectors.toList());
	}

	public int size() {
		return players.size();
	}

	public List<RacingRecord> drive() {
		return players.stream()
				.map(entrySlot -> {
					entrySlot.drive();
					return new RacingRecord(entrySlot.getPlayerName(), entrySlot.getCarMilieage());
				}).collect(Collectors.toList());
	}
}
