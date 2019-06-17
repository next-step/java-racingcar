package step2;

public class ResultView {

    public void result(int[] carPositions){

        for(int i =0; i < carPositions.length; i++){
            outputView(carPositions[i]);
        }
        System.out.println();
    }

    private void outputView(int num){
        for(int i =num; i > 0; i--){
            System.out.print("-");
        }
        System.out.println();
    }
}
