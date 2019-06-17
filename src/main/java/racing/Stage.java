package racing;

public class Stage {


	private Stage(){

	}



	public static StageBuilder builder() {

		return new StageBuilder();
	}

	public int getCountOfPlayers() {
		return 0;
	}

	public int remainingLabs() {
		return 0;
	}


	public static class StageBuilder{


		public Stage build() {

			return new Stage();
		}
	}
}
