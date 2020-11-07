package racing.view;

import racing.domain.Car;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static racing.domain.CarConfig.*;

public class ResultView {

    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String SKID_MARK = "-";


    private Map<String,StringBuilder> map = new HashMap<>();

    public void racingResults(List<Car> cars,int maxLaps) {
        System.out.print("\n");
        System.out.printf("%s \n",EXECUTE_RESULT);
        System.out.print("\n");

        int laps = 0;
        do {
            for(Car car:cars) {
                parseSkidMark(car.getEcu().findRecord(laps));
            }
            System.out.println();
            laps++;
        }while (laps < maxLaps);
    }

    public void parseSkidMark(String raceRecord) {
        raceRecord = Pattern.compile(ECU_RECORD_STRING_SEPARATOR)
                .splitAsStream(raceRecord)
                .filter(str -> !"0".contains(str))
                .collect(Collectors.joining());
        System.out.println(raceRecord.replaceAll(ECU_NORMAL_MOVE_CODE,SKID_MARK));
    }

}
