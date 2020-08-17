package step3;

import java.util.List;

public class ResultView {

    void showCurrentPosition(int currentCount, int successCount){
        if(currentCount < successCount){
            for(int i = 0; i < currentCount; i++){
                System.out.print("-");
            }
            System.out.println("");
            return;
        }

        for(int i = 0; i < successCount; i++){
            System.out.print("-");
        }
        System.out.println("");
    }

}
