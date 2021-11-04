package domain;

public class CarRace {
	private final String[] carRace;

	public CarRace(String[] carRace){
		this.carRace = carRace;
	}

	public String position(int index){
		return carRace[index];
	}

	public int size(){
		return carRace.length;
	}
}
