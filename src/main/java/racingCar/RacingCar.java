package racingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static void RacingCarGame(){
        List<Integer> inputList = InputView.Input();
        int N = (int) inputList.get(0);
        int M = (int) inputList.get(1);

        List<String> stringList = CarConstructor(N);

        System.out.println("\n실행 결과");
        while(M>0){
            for (int i =0; i < N; i++) {
                IsAdvance(stringList, i);
                ResultView.Result(stringList, i);
            }
            System.out.println("");
            M--;
        }
    }

    private static List<String> CarConstructor(int N){
        List<String> stringList = new ArrayList<>();
        for (int i =0; i < N; i++) {
            stringList.add("-");
        }
        return stringList;
    }

    private static int RandomNumber(){
        return (int) (Math.random()*10);
    }

    private static void IsAdvance(List<String> stringList, int i){
        int tmp = RandomNumber();
        if(tmp >=4){
            stringList.set(i, stringList.get(i)+"-");
        }
    }

    public static void main(String[] args) {
        RacingCar.RacingCarGame();
    }
}
