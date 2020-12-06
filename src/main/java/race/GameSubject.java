package race;

public interface GameSubject {
	void registerObserver(GameObserver observer);

	void notifyObserver();
}
