import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

public class LMS_Baitap3 {
    public static void main(String[] args) {
        List<Integer> listInt = new ArrayList<>();
        listInt.add(23);
        listInt.add(1);
        listInt.add(17);
        listInt.add(65);
        listInt.add(28);
        listInt.add(8);
        Collections.sort(listInt);
        System.out.println("Danh sách theo thứ tự gỉm dần là: "+listInt);
    }


}
