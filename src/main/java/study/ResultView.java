package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static study.RacingCar.BLANK;
import static study.StringAddCalculator.ZERO;

public class ResultView {

    public static void result(ArrayList<RacingCar> carList){

        String champians = BLANK;
        int carNum = carList.size();
        int loopNum = ZERO;
        if(carList.size()==0){
            System.out.println("차량들이 레이싱을 하지 않았습니다.");
        }

        loopNum = carList.get(0).getLoopCount();
        System.out.println("실행 결과");

        for(int i = 0; i<loopNum; i++){

            for(int j = 0; j<carNum ; j++){
                carList.get(j).move(i);
            }
            System.out.println();
        }
        /**
         * sort 출력
         */

        System.out.println("가 최종 우승했습니다.");

    }

}
