package racing;


import java.util.HashMap;
import java.util.Map;

public class RacingCar {

    Map<Integer, Integer> carMoveCountMap = new HashMap<>();
    public void racing(int carNum, int count) {
        //init
        for (int i=0; i<carNum; i++) {
            carMoveCountMap.put(i, 0);
        }
        int j=0;
        while(j < count) {
            setCarMoveCount(carNum);
            j++;
        }


    }

    void printRace(int carNum) {
        int i=0;
        while(i < carNum) {
            printMoveLine(i);
            System.out.println("");
            i++;
        }
    }

    void printMoveLine(int carNum) {
        System.out.print(carNum*1+1+":");
        for (int j=0; j<carMoveCountMap.get(carNum); j++) {
            System.out.print("-");
        }
    }

    void setCarMoveCount(int carNum) {
        for(int i=0; i<carNum; i++) {
            setMove(i);
        }
        printRace(carNum);
        System.out.println("");
    }

    void setMove(int carNum) {
        if (isMove(getRandomValue())) {
            int moveCount = carMoveCountMap.get(carNum).intValue();
            carMoveCountMap.put(carNum, ++moveCount);
        }
    }

    public int getRandomValue() {
        return (int)(Math.random() * 9);
    }

    public boolean isMove(int randomValue) {
        if (randomValue >= 4) {
            return true;
        }
        return false;
    }
}
