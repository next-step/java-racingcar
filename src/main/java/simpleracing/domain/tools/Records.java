package simpleracing.domain.tools;

import static java.util.stream.Collectors.joining;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Records {
	private List<Record> records;

	public String viewRecord() {
		return records.stream()
					  .map(record -> record.getCarName() + " : " + record.drawLocation())
					  .collect(joining("\n"));
	}
}
