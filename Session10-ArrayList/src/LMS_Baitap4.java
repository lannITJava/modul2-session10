import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LMS_Baitap4 {
    public static void main(String[] args) {
        String string = "Rekkei Academy để nông dân biết code";
        List<String> stringList = new ArrayList<>();
        String[] listStr = new String[string.length()];
        listStr= string.split("\\s");
        for (String str: listStr) {
            stringList.add(str);
        }
        System.out.println("Các phần tử có nhiều hơn 3 ký tự");
        for (String str: stringList) {
            if (str.length()>3){
                System.out.println(str);
            }
        }
    }
}
