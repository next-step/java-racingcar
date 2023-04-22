package car;

public class ResultView {

    public void resultView(Car car){
        System.out.print(car.getName()+" : ");
        LinePrint(car.getPosition());

    }

    public void LinePrint(int size){
        for (int i = 0; i < size; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
