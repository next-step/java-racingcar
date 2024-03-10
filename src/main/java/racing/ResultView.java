package racing;

import java.util.List;

public class ResultView {

    private final CarRacing carRacing;

    public ResultView(CarRacing carRacing) {
        this.carRacing = carRacing;
    }

    public void showView(){
        List<List<String>> racing = carRacing.startRacing();
        System.out.println("실행결과");
        for (List<String> steps : racing) {
            for (String carLevel : steps) {
                System.out.println(carLevel);
            }
            System.out.println();
        }
    }
}
