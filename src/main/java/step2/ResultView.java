package step2;

public class ResultView {

    public void result(int[] carPositions){

        System.out.println("==========");

        for(int i =0; i < carPositions.length; i++){
            outputView(carPositions[i]);
        }
    }

    private void outputView(int num){
        for(int i =num; i > 0; i--){
            System.out.print("-");
        }
        System.out.println();
    }
}
