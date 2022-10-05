package nextstep.javaracingcar;

import java.util.Iterator;

class IntegerIterator implements Iterator<Integer> {

    private int size;
    private int index;

    IntegerIterator(final int size) {
        this.index = 0;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return size > 0;
    }

    @Override
    public Integer next() {
        size--;
        return index++;
    }
}
