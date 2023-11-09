package racingCar;

public class ResultView {

    private ResultView(){}

    public static void print(int printCnt){
        for(int i=0; i<printCnt; i++){
            System.out.print("-");
        }
        System.out.println();
    }

}
