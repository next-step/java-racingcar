package racingCar;

public class ResultView {
    private static final String RESULT_TITLE = "실행 결과";

    public void printTitle(){
        System.out.println(RESULT_TITLE);
    }

    public void printResult(String[] arr){
        for(String str : arr){
            System.out.println(str);
        }
        System.out.println();
    }
}
