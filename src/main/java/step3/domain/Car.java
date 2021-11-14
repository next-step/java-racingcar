package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private List<Integer> positionList = new ArrayList<>();

    public void move(CarOperation carOperation) {
        int movedPosition = getCurrentPosition() + carOperation.getValue();
        positionList.add(movedPosition);
    }

    private int getCurrentPosition() {
        if(positionList.size()==0){
            return 0;
        }
        return positionList.get(positionList.size() - 1);
    }

    public int getPosition(int idx) {
        return positionList.get(idx);}

}