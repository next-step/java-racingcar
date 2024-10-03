package racingcar.study.immutable.example;

import java.util.Arrays;

public class ArrayObject {

    private final int[] array;

    public ArrayObject(final int[] array) {
//            this.array = array;
        this.array = Arrays.copyOf(array, array.length);
    }


    public int[] getArray() {
//            return array;
        return (array == null) ? null : array.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayObject that = (ArrayObject) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

}
