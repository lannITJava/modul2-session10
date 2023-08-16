import java.util.*;

public class LMS_Baitap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            int number = random.nextInt(1, 101);
            listInt.add(number);
        }
        System.out.println("Các phần tử trong mảng listInt là: "+listInt);
        System.out.println("Max = "+ Collections.max(listInt));
    }
}
