package racingcar.domain;

public class CountOfGamePlay {
	private final int playCount;

	public CountOfGamePlay(int playCount) {
		this.playCount = playCount;
	}

	public RacingCars run(RacingCars racingCars, EngineStrategy engineStrategy) {
		for (int i = 0; i < playCount; i++) {
			racingCars.play(engineStrategy);
		}
		return racingCars;
	}
}
