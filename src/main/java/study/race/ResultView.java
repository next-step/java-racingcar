package study.race;

public class ResultView {
    public static void resultView(Car[] carNumber) {

        for(int i=0; i< carNumber.length; i++){
            String outPut = "-";
            outPut = outPut.repeat(carNumber[i].position);
            System.out.println(outPut);
        }

    }
}