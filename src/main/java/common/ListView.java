package common;

import java.util.List;

public class ListView<V extends View> {

    private final List<V> list;

    public ListView(List<V> viewList) {
        this.list = viewList;
    }

    public void print() {
        for (View v : this.list) {
            v.print();
        }
        System.out.println();
    }

    public List<V> getList() {
        return list;
    }
}
