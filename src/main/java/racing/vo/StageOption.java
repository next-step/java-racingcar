package racing.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StageOption {

	private int entrySize;

	private int roundLimit;

	public StageOption(int entrySize, int roundLimit){

		this.entrySize = entrySize;
		this.roundLimit = roundLimit;
	}

	public StageOption(String entryInformation, String separator, int roundLimit) {

	    String[] fragments = entryInformation.split(separator);
        List<String> entry = Arrays.stream(fragments)
                .map(name -> name.trim())
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());

        this.entrySize = entry.size();
        this.roundLimit = roundLimit;

	}

	public int getEntrySize(){
		return entrySize;
	}

	public int getRoundLimit(){
		return roundLimit;
	}

    public String getPlayerName(int i) {
	    return "";
    }
}
