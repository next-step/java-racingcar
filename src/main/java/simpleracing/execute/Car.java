package simpleracing.execute;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = {"id"})
public class Car {
	private int id;
	private String name;
	private CarGame carRacingGame;
	private String location;

	public Car(int id, String name, CarGame carRacingGame) {
		this.id = id;
		this.name = name;
		this.carRacingGame = carRacingGame;
		this.location = Direction.STOP.getSign();
	}

	public void play() {
		carRacingGame.play(this);
	}

	public String getLocation() {
		return this.location;
	}

	public String getName() {
		return this.name;
	}

	public void move(Direction direction) {
		location += direction.getSign();
	}
}
