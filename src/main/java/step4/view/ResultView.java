package step4.view;



import java.util.List;

public class ResultView {

    public void printRacingResultStartText() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRacingStatus(List<?> Objects) {
        Objects.forEach(System.out::println);
        System.out.println();
    }

    public void printChampionCars(Object object) {
        System.out.println(object);
    }
}
