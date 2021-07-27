package racing;

import java.util.ArrayList;

public class ShowRacing {

    public static void showGame(int cntSize, int carListSize, int idx) {

        String movement = "";

        for(int cnt = 0; cnt < cntSize; cnt++) {
            movement = movement + "-";
        }

        System.out.println(movement);

        if(idx == carListSize - 1) {
            System.out.println("");
        }

    }
}
