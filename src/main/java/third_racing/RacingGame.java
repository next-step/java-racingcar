package third_racing;


import java.util.List;
import java.util.Random;

public class RacingGame {


    public static void main(String[] args) {
        Inputview inputview = new Inputview();

        int carNo = inputview.userCarNoInput();

        inputview.userTryNoInput(carNo);
    }


}


