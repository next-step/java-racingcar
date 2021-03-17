package study.step3;

import java.util.stream.Collectors;

public class RaceGame {
    public static void main(String[] args){
        String carNames = InputView.getCarsName();
        Cars cars = Cars.of(carNames);
        int tryCnt = InputView.getTryCnt();
        System.out.println("실행 결과");
//        for(int i=0;i<tryCnt;i++){
//            ResultView.output(cars);
//            System.out.println();
//        }
//
//        String result = String.join(",", cars.getWinners()
//                .stream()
//                .map(car -> car.getCarName())
//                .collect(Collectors.toList()));
//        System.out.println(result + "가 최종우승했습니다.");
    }
}
