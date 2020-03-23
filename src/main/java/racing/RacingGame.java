package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RacingGame {
	
	public static final int INIT_CAR_POSITION = 0;
	private static final int RANDOM_LIMIT = 10;
	private static final int IS_CASE_FORWARD_MIN = 4;
	private static final int FORWARD_UNIT = 1;
	
	private int time;
	private ArrayList<Integer> carPositions;
	
	public RacingGame(int car, int time) {
		this.carPositions = new ArrayList<>(Collections.nCopies(car, INIT_CAR_POSITION));
		this.time = time;
	}

	public ArrayList<Integer> getCarPositions() {
		return carPositions;
	}
	public int getTime() {
		return time;
	}

	public ArrayList<Integer> move() {
		for (int i = 0; i < carPositions.size() ; ++i) {
			if ( isCaseForward() ) {
				carPositions.set(i, carPositions.get(i) + FORWARD_UNIT);
			}
		}
		return carPositions;
	}

	private boolean isCaseForward() {
		Random random = new Random();
		return random.nextInt(RANDOM_LIMIT) > IS_CASE_FORWARD_MIN;
	}
}
