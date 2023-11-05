package study;

import lombok.*;
import java.util.Map;

@NoArgsConstructor
public class RacingCar {

    public static final int ZERO = 0;
    public static final String BLANK = "";

    @Getter @Setter
    private int drive = ZERO;

    @Getter @Setter
    private int stop = ZERO;

    @Getter @Setter
    private int loopCount = ZERO;

    @Getter @Setter
    private Map<Integer, Double> randomList;

    public void move(int stepNo){

        String moveStr = BLANK;

        for(int i=0; i<=stepNo; i++){

            if(randomList.get(i).doubleValue()>=4){
                moveStr+="-";
            }
        }

        System.out.println(moveStr);
    }

}




