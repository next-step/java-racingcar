package racingcar;


public class Request {
    private final String[] names;
    private final int totalRound;

    public Request(String names, String totalRound) {
        this.names = Parser.parse(names);
        this.totalRound = Integer.parseInt(totalRound);
    }

    public String[] getNames() {
        return names;
    }

    public int getTotalRound() {
        return totalRound;
    }
}
