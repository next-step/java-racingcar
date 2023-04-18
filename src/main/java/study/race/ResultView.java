package study.race;

public class ResultView {
    public static void resultView(int[] carNumber) {

        for(int i=0; i< carNumber.length; i++){
            String outPut = "-";
            outPut = outPut.repeat(carNumber[i]);
            System.out.println(outPut);
        }

    }
}