package nextstep.javaracingcar.domain;

import java.util.Iterator;

class SizeIterator implements Iterator<Integer> {

    private int size;
    private int index;

    SizeIterator(final int size) {
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
