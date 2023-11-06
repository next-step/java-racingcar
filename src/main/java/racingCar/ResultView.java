package racingCar;

import java.util.List;

public class ResultView {

    private String resultMessage;
    private final List<String> result;

    ResultView(List<String> result){
        this.result = result;
    }

    public void printResult(String resultMessage){
        System.out.println(resultMessage);
        result.forEach(System.out::println);
    }

}
