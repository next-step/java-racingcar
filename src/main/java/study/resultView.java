package study;

public class resultView {
    public static void resultView(int[] carNumber) {

        for(int i=0; i< carNumber.length; i++){
            String outPut = "-";
            outPut = outPut.repeat(carNumber[i]);
            System.out.println(outPut);
        }

    }
}