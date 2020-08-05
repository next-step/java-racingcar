package simpleracing.execute;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = {"id"})
public class Car {
	private int id;
	private List<Integer> randomValues;
	private CarGame carRacingGame;

	public Car(int id, CarGame carRacingGame) {
		this.id = id;
		this.carRacingGame = carRacingGame;
		this.randomValues = new ArrayList<>();
	}

	public void play() {
		carRacingGame.play(this);
	}

	public List<Direction> getDirections() {
		return randomValues.stream()
						   .map(value -> Direction.getBy(value))
						   .collect(toList());
	}

	public void addGameResult(int result) {
		this.randomValues.add(result);
	}

	public String getLocationOf(int round) {
		String currentValue = "";
		for (int i = 0; i < round; i++) {
			String current = Direction.getBy(randomValues.get(i)).getSign();
			currentValue += current;
		}
		return currentValue;
	}

	public String getLocation() {
		return getLocationOf(randomValues.size());
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
