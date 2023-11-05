package study;

import java.util.Map;
import static study.StringAddCalculator.ZERO;

public class ResultView {

    public static void result(Map<String,RacingCar> carMapList){

        int carNum = carMapList.size();
        int loopNum = ZERO;
        if(carMapList.size()==0){
            System.out.println("차량들이 레이싱을 하지 않았습니다.");
        }

        loopNum = carMapList.get("CarNo0").getLoopCount();
        System.out.println("실행 결과");

        for(int i = 0; i<loopNum; i++){

            for(int j = 0; j<carNum ; j++){
                carMapList.get("CarNo"+j).move(i);
            }
            System.out.println();
        }

//        System.out.println("===============>");
//        for(int j = 0; j<carNum ; j++){
//            System.out.println(carMapList.get("CarNo"+j).getRandomList().toString());
//        }

    }


}
