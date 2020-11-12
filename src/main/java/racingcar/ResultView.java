package racingcar;

import java.util.List;
import java.util.Scanner;

public class ResultView {
    int counts;
    int attempts;


    public ResultView(int counts, int attempts){
        this.counts = counts;
        this.attempts = attempts;
    }

    //시도 횟수별 자동차 이동경로 값 가져오기
    public void showResult(List<Car> carList){
        System.out.println("실행 결과");
        for(int i=0;i<this.attempts;i++){
            printDistance(carList, i);
        }
    }
    public String intToStr(int distance){
        String distanceStr="";

        while(distance >0){
            distanceStr+="-";
            distance-=1;
        }

        return distanceStr;
    }

    //이동 결과 그리기
    public void printDistance(List<Car> carList, int num){
        for(int i=0;i<this.counts;i++){
            Car afterRacingCar  = carList.get(i);
            int distance = afterRacingCar.getRecordList().get(num);
            System.out.println(this.intToStr(distance));
        }
        System.out.println();

    }
    public void announceWinner(List<String> winners){
        String announceMessage="";
        for(int i=0;i<winners.size();i++){
            announceMessage+=winners.get(i);
            if(i != winners.size()-1){
                announceMessage+=" ,";
            }
        }
        announceMessage+="가 최종 우승했습니다.";
        System.out.println(announceMessage);
    }
}