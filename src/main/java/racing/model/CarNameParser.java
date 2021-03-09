package racing.model;

public class CarNameParser {

    private final String participationList;

    public CarNameParser(String participationList) {
        this.participationList = participationList;
    }

    public String[] parse() {
        return this.participationList.split(",");
    }


}
