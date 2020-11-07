package racingcar;

import java.util.Scanner;

public class ResultView {
    int counts;
    int attempts;


    public ResultView(int counts, int attempts){
        this.counts = counts;
        this.attempts = attempts;
    }

    //시도 횟수별 자동차 이동경로 값 가져오기
    public void showResult(Car[] car){
        System.out.println("실행 결과");
        for(int i=0;i<this.attempts;i++){
            printDistance(car, i);
        }
    }

    //이동 결과 그리기
    public void printDistance(Car[] car,int num){
        for(int i=0;i<this.counts;i++){
            System.out.println(car[i].recordDistance.get(num));
        }
        System.out.println();

    }
}
