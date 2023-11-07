package step4_racintCarWithWinner;

import java.util.List;

public class ResultView<T> {

    public void print(List<T> list){
        list.forEach(System.out::println);
        System.out.println();
    }
}
