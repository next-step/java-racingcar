package racing.domain;

import racing.vo.PlayerRecord;

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

	public List<PlayerRecord> drive() {
		return items.stream()
				.map(entryItem -> entryItem.drive())
				.collect(Collectors.toList());
	}

}
