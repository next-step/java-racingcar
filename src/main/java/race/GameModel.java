package race;

public interface GameModel {
	void registerObserver(GameObserver observer);

	void notifyObserver();
}
