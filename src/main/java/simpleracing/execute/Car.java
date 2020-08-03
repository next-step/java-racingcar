package simpleracing.execute;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = {"id"})
public class Car {
	private int id;
	private List<Integer> randomValues;

	public Car(int id, List<Integer> randomValues) {
		this.id = id;
		this.randomValues = randomValues;
	}

	public List<Direction> getDirections() {
		return randomValues.stream()
						   .map(value -> Direction.getBy(value))
						   .collect(toList());
	}

	public int getTryCount() {
		return this.randomValues.size();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
