package study;

import java.util.ArrayList;
import static study.RacingCar.BLANK;
import static study.RacingCarGame.*;

public class ResultView {

    public static void result(ArrayList<RacingCar> carList,int stepNum){

        int carNum = carList.size();
        int loopNum = stepNum;
        String champions = BLANK;

        if(carList.size()==0){
            throw new IllegalArgumentException("차량들이 레이싱을 하지 않았습니다.");

        }

        System.out.println("실행 결과");

        for(int i = 0; i<loopNum; i++){

            for(int j = 0; j<carNum ; j++){
                System.out.println(carList.get(j).move(i));
            }
            System.out.println();
        }
        /**
         * Champion 출력
         */
        int maxCount = maxStep(carList);

        /**
         * Champion List 가져오기
         */
        ArrayList<RacingCar> championList = championList(carList,maxCount);

        champions = combineName(championList);

        System.out.println(champions+"가 최종 우승했습니다.");

    }

}
