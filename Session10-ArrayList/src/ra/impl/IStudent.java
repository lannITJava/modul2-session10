package ra.impl;

import java.util.List;
import java.util.Scanner;

public interface IStudent {
    int MARK_PASS = 5;
    void inputData(Scanner scanner, List<Student> listStudent);
    void displayData();
    void calAvgMark();

}
