package step3;

import java.util.ArrayList;

public class InputDto {

    public ArrayList<String> nameList;
    public int numberOfTrial;

    public InputDto(ArrayList<String> nameList, int numberOfTrial) {
        this.nameList = nameList;
        this.numberOfTrial = numberOfTrial;
    }

    public ArrayList<String> getNameList() {
        return nameList;
    }

    public int getNumberOfTrial() {
        return numberOfTrial;
    }
}
