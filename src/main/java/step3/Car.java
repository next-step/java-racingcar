package step3;

import java.util.ArrayList;

public class Car {
    private ArrayList<Integer> positionHistory;

    Car(){
        positionHistory = new ArrayList<>();
        positionHistory.add(0);
    }

    public ArrayList<Integer> getPositionHistory(){
        return positionHistory;
    }

    public void moveForward(boolean success){
        if(success){
            positionHistory.add(positionHistory.get(positionHistory.size() -1) + 1);
            return;
        }
        positionHistory.add(positionHistory.get(positionHistory.size() -1));
    }

}