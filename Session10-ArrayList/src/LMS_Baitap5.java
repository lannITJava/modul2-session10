import java.util.ArrayList;
import java.util.List;

public class LMS_Baitap5 {
    public static void main(String[] args) {
        String string = "Rekkei Academy để nông dân biết code";
        List<String> stringList = new ArrayList<>();
        String[] listStr = new String[string.length()];
        listStr= string.split("\\s");
        for (String str: listStr) {
            stringList.add(str);
        }

        String minWord = stringList.get(0);
        for (String str: stringList){
            if (minWord.length()>str.length()){
                minWord= str;
            }
        }
        System.out.println("Phần tử có ít ký tự nhất là: "+minWord);
    }
}
