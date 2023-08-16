import java.util.ArrayList;
import java.util.List;

public class LMS_Baitap2 {
    public static void main(String[] args) {
        List<Integer> listInt = new ArrayList<>();
        listInt.add(4);
        listInt.add(45);
        listInt.add(5);
        listInt.add(15);
        List<Integer> listNew = new ArrayList<>();
        for (int i = listInt.size()-1; i>=0; i--) {
            listNew.add(listInt.get(i));
        }
        System.out.println("Mảng đảo ngược là: "+listNew);
    }
}
