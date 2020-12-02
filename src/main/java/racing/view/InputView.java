package racing.view;

public class InputView {
	private int playCount;
	private int playCarCount;

	public InputView() {
	}

	public InputView(int playCount, int playCarCount) {
		this.playCount = playCount;
		this.playCarCount = playCarCount;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	public int getPlayCarCount() {
		return playCarCount;
	}

	public void setPlayCarCount(int playCarCount) {
		this.playCarCount = playCarCount;
	}

	@Override
	public String toString() {
		return "InputView{" +
				"playCount=" + playCount +
				", playCar=" + playCarCount +
				'}';
	}
}
