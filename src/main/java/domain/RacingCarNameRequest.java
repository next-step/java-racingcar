package domain;

public class RacingCarNameRequest {
    private String[] nameList;

    public RacingCarNameRequest(String[] nameList) {
        this.nameList = nameList;
    }

    public String[] getNameList() {
        return nameList;
    }
}
