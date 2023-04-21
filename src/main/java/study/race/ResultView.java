package study.race;

import java.util.List;

public class ResultView {
    public static void resultView(List<Car> carNumber) {

        for(int i=0; i< carNumber.size(); i++){
            String outPut = "-";
            outPut = outPut.repeat(carNumber.get(i).position);
            System.out.println(outPut);
        }

    }
}