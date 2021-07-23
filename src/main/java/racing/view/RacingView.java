package racing.view;

import java.util.Map;

public class RacingView {

    void printMoveLine(int carMove) {
        for (int i=0; i<carMove; i++) {
            System.out.print("-");
        }
    }

    public void printRace(Map<Integer, Integer> carMoveCountMap, int carNum) {
        int i=0;
        while(i < carNum) {
            printMoveLine(carMoveCountMap.get(carNum));
            System.out.println("");
            i++;
        }
    }
}
