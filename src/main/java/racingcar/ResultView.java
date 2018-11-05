package racingcar;

public class ResultView {

    public static void result(int[] carPosition){
        for (int position : carPosition){
            System.out.println(positionGrid(position));
        }
        System.out.println();
    }

    public static String positionGrid(int carPerPosition){
        String str = "";
        for(int i=0; i<carPerPosition; i++){
            str += "-";
        }
        return str;
    }

}
