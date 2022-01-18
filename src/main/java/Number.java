import java.util.ArrayList;
import java.util.List;

public class Number {

    private List<Integer> numbers;

    public Number() {
        numbers = new ArrayList<>();
    }

    public void addNumber(int num) {
        numbers.add(num);
    }

    public void print() {
        System.out.println("Number Class========");
        for (Integer i : numbers) {
            System.out.println(i);
        }
    }
}
