package racingcar.ui;

import java.util.stream.Stream;

import racingcar.domain.MotorRacing;
import racingcar.ui.dto.MotorRacingDisplayResults;

public class MotorRacingDisplay {
    public static void racingResultDisplay(Counter counter){
        final MotorRacing motorRacing = MotorRacing.randomMotorRacing(counter.getCarCout());
        display("실행 결과");

        MotorRacingDisplayResults results = motorRacing.racing(counter.getTryCount());
        display(results);

    }

    public static void display(Object o){
        display(o.toString());
    }

    public static void display(String msg){
        System.out.println(msg);
    }

    public static void newLine(int newLineCount){
        Stream
            .iterate(0,(i)->i+1)
            .limit(newLineCount)
            .map(e->"\n")
            .forEach(System.out::print);
    }
}
