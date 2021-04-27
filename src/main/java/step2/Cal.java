package step2;

public class Cal {

    private static String[] array = {"+","-","*","/"};

    public String[] calsachicInput(String[] word){
        String[] result = null;
        for(int i = 0 ;i<array.length;i++) {
            if (word.equals(array[i])) {
                result[i] = array[i];
            }
        }
        return result;
    }
  //  String sampleword ="2 + 3 * 4 / 2";

    public String[] splitWord(String sampleword){
        sampleword =  sampleword.replaceAll(" ", "");
        String[] arr = new String[sampleword.length()];

        for (int i = 0; i < sampleword.length(); i++) {
            arr[i] = sampleword.substring(i,i+1);
        }
        return arr;
    }

    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    int sub(int a, int b) {
        int result = a - b;
        return result;
    }

    int mul(int a, int b) {
        int result = a * b;
        return result;
    }

    int mol(int a, int b) {
        int result = a / b;
        return result;
    }



}
