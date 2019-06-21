package racing.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StageOption {

	private List<String> entry;

	private int roundLimit;

	public StageOption(String playNames, String separator, int roundLimit) {

	    String[] fragments = playNames.split(separator);

        this.entry = Arrays.stream(fragments)
                .map(name -> name.trim())
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());

        this.roundLimit = roundLimit;

	}

	public int getEntrySize(){
		return entry.size();
	}

	public int getRoundLimit(){
		return roundLimit;
	}

    public String getPlayerName(int i) {
	    return this.entry.get(i);
    }
}
