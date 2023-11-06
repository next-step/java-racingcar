package study.utils;

import java.util.ArrayList;

public class ArrayListUtils {

    private ArrayListUtils() {  //인스턴스화 방지
    }

    public static ArrayList<String>[] get2ArrayList(int arrayLength) {
        ArrayList<String>[] arrayList = new ArrayList[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            arrayList[i] = new ArrayList<String>();
        }
        return arrayList;
    }
}
