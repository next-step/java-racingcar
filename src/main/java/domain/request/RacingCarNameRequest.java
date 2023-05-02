package domain.request;

import java.util.List;

public class RacingCarNameRequest {
    private List<String> nameList;

    public RacingCarNameRequest(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<String> getNameList() {
        return nameList;
    }
}
