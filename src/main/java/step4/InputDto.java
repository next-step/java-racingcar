package step4;

import java.util.List;

public class InputDto {

    public List<String> nameList;
    public int numberOfTrial;

    public InputDto(List<String> nameList, int numberOfTrial) {
        this.nameList = nameList;
        this.numberOfTrial = numberOfTrial;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public int getNumberOfTrial() {
        return numberOfTrial;
    }
}
