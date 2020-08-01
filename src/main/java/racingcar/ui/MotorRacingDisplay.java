package racingcar.ui;

import java.util.stream.Stream;

import racingcar.ui.dto.MotorRacingDisplayResults;

public class MotorRacingDisplay {
    public static void racingResultDisplay(MotorRacingDisplayResults results){
        display("실행 결과");
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
