package simpleracing.execute;

public interface CarGame {
	void play();

	void judge(CarRacingReferee referee);

	String getRacingResult();
}
