import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class stringStep1 {
    public static void main(String[] args) throws Exception {
//         stringStep1_1();
         stringStep1_2();
//         stringStep1_3();
    }

@Test
 private static String[] stringStep1_1() throws Exception {
String number ="1,2";
    String[] numAry = number.split(",");

    for (int i=0; i<numAry.length;i++){
        assert numAry[i].contains("1");
        assert numAry[i].contains("2");
        System.out.println("::numAry::"+numAry[i]);
    }

    return numAry;
}

//"(1,2)"-substring
 @Test
    private static String stringStep1_2() throws Exception{
    String numberSub = "(1,2)";
        String numSub = numberSub.substring(1,4);
     System.out.println("::numSub::"+numSub);
        return numSub;
    }

    @Test
    @DisplayName("indexExceptionTest")
    private static void stringStep1_3() throws Exception{
        try{
            String abc = "abc";
//            for(int i =0; i<abc.length();i++){
//                System.out.println(abc.charAt(i));
//            }
            char abcException = abc.charAt(10);
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("!!!!! StringIndexOutOfBoundsException !!!!!");
        }
    }
}
