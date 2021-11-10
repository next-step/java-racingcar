package common;

import java.util.List;

public class ListView<V extends View> {

    private final List<V> viewList;

    public ListView(List<V> viewList) {
        this.viewList = viewList;
    }

    public void print() {
        for (View v : this.viewList) {
            v.print();
        }
        System.out.println();
    }

    public List<V> getViewList() {
        return viewList;
    }
}
