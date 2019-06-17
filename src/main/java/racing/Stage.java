package racing;

public class Stage {

	private int players;

	private int round;

	private Stage(StageBuilder stageBuilder){
		this.round = stageBuilder.round;
		this.players = stageBuilder.entry;

	}

	public int getCountOfPlayers() {
		return players;
	}

	public int remainingRounds() {
		return round;
	}


	public static StageBuilder builder(int entry, int round) {

		return new StageBuilder(entry, round);
	}

	public static class StageBuilder{

		private int entry;

		private int round;

		private StageBuilder(int entry, int round) {
			this.entry = entry;
			this.round = round;
		}

		public Stage build() {
			return new Stage(this);
		}
	}
}
