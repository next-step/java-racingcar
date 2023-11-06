package study;

import lombok.*;
import java.util.Map;

@NoArgsConstructor
public class RacingCar {

    public static final int ZERO = 0;
    public static final String BLANK = "";
    public static final String DASH = "-";
    public static final int CONDITION_VAL = 4;

    @Getter @Setter
    private int drive = ZERO;

    @Getter @Setter
    private int stop = ZERO;

    @Getter @Setter
    private int loopCount = ZERO;

    @Getter @Setter
    private Map<Integer, Double> randomsByStep;

    public void move(int stepNo){

        String moveStr = BLANK;

        for(int i=0; i<=stepNo; i++){

            if(randomsByStep.get(i)>= CONDITION_VAL){
                moveStr+= DASH;
            }
        }

        System.out.println(moveStr);
    }

}




