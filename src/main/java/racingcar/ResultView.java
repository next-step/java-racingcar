package racingcar;

import java.util.List;

public class ResultView {
    private final int counts;
    private final int attempts;


    public ResultView(int counts, int attempts){
        this.counts = counts;
        this.attempts = attempts;
    }

    //시도 횟수별 자동차 이동경로 값 가져오기
    public void showResult(Cars cars){
        System.out.println("실행 결과");
        for(int i=0;i<attempts;i++){
            printDistance(cars, i);
        }
    }
    public String intToStr(int distance){
        StringBuilder distanceStr= new StringBuilder();

        while(distance >0){
            distanceStr.append("-");
            distance-=1;
        }

        return distanceStr.toString();
    }

    //이동 결과 그리기
    public void printDistance(Cars cars, int num){
        for(int i=0;i<counts;i++){
            int distance = cars.oneOfCars(i).getRecord(num);
            System.out.println(this.intToStr(distance));
        }
        System.out.println();

    }
    public void announceWinner(List<String> winners){
        StringBuilder announceMessage= new StringBuilder();
        for(int i=0;i<winners.size();i++){
            announceMessage.append(addComma(winners,i));
       }
        announceMessage.append("가 최종 우승했습니다.");
        System.out.println(announceMessage);
    }

    public String addComma(List<String> winners, int count){
        if(count != winners.size()-1){
            return winners.get(count)+ ", ";
        }
        return winners.get(count);
    }
}