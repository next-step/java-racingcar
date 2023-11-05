package racingCar;

import java.util.List;

public class ResultView {

    private String resultMessage = "실행 결과";
    private final List<String> result;

    ResultView(List<String> result){
        this.result = result;
    }

    ResultView(List<String> result, String resultMessage){
        this.result = result;
        this.resultMessage = resultMessage;
    }
    public void printResult(){
        System.out.println(this.resultMessage);
        result.forEach(System.out::println);
    }

}
