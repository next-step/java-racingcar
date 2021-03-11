package new_racingcar;

import java.util.List;

public class ResultView {

    public void printGameStart() {
        System.out.println("");
        System.out.println("실행결과");
    }

    public void printGrandPrixRecords(List<Car> cars) {
        cars.stream()
                .forEach(fo -> printLab(fo.getRecord()));

        System.out.println("");
    }

    private void printLab(Record record) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < record.getDistance(); i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }
}
