package racing.vo;

public class StageOption {

	private int entrySize;

	private int roundLimit;

	public StageOption(int entrySize, int roundLimit){

		this.entrySize = entrySize;

		this.roundLimit = roundLimit;
	}

	public int getEntrySize(){
		return entrySize;
	}

	public int getRoundLimit(){
		return roundLimit;
	}
}
