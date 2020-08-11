package core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Car {
    List<String> roundResult;

    Car() {
        roundResult = new ArrayList<>();
    }

    public Stream<String> stream() {
        return roundResult.stream() ;
    }

    public void addResult(String result) { roundResult.add(result) ; }
}
