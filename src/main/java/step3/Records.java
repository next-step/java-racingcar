package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Records {
	private final List<Record> records;

	public Records() {
		this.records = new ArrayList<>();
	}

	public void add(Record record) {
		records.add(record);
	}

	public List<List<Integer>> getResult() {
		return records.stream()
			.map(Record::getResult)
			.collect(Collectors.toList());
	}
}
