package step4;

import java.util.List;
import java.util.Objects;

public class Result {

    private List<Car> result;

    public Result(List<Car> result) {
        this.result = result;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
