package race.domain;

public interface MovePolicy {
	int INCREASE_DISTANCE_NUMBER = 1;
	boolean move();

	int distance();
}
