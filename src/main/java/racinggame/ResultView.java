package racinggame;

public class ResultView {

    public void print(int[] carPosition) {
        for(int i =0; i < carPosition.length; i++){
            printCar(carPosition[i]);
        }
        System.out.println();
    }

    private void printCar(int location) {
        for(int i =0; i < location; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
