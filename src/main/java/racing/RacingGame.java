package racing;

import java.util.ArrayList;
import java.util.Collections;

public class RacingGame {
	
	public static final int INIT_CAR_POSITION = 0;
	
	private int time;
	private ArrayList<Integer> carPositions;
	
	public RacingGame(int car, int time) {
		this.carPositions = new ArrayList<>(Collections.nCopies(car, INIT_CAR_POSITION));
		this.time = time;
	}

	public ArrayList<Integer> getCarPositions() {
		return carPositions;
	}
}
