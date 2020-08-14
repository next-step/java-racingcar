package simpleracing.domain.tools;


import static java.util.stream.Collectors.joining;

import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Record {

	private String carName;
	private int location;

	public String drawLocation() {
		return IntStream.range(0, location)
						.mapToObj(i -> "-")
						.collect(joining());
	}
}
