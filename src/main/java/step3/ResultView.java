package step3;

public class ResultView {

    public void resultView(Car car){
        for (int i=0; i < car.getCount(); i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
