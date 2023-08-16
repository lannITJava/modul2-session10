package ra.run;

import ra.impl.Student;

import java.util.*;

public class StudentManagement {
    static List<Student> listStudent = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.println("***************************MENU*************************");
            System.out.println("1. Nhập thông tin n sinh viên (n nhập từ bàn phím)");
            System.out.println("2. Tính điểm trung bình tất cả sinh viên");
            System.out.println("3. Đánh giá xếp loại các sinh viên");
            System.out.println("4. Tính trạng thái của sinh viên");
            System.out.println("5. In thông tin các sinh viên");
            System.out.println("6. Sắp xếp sinh viên tăng dần theo điểm trung bình");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê sinh viên theo xếp loại");
            System.out.println("9. Thống kê sinh viên theo trạng thái");
            System.out.println("10. Thoát");
            System.out.println("Sự lựa chọn của bạn là: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    StudentManagement.inputListStudent(scanner);
                    break;
                case 2:
                    StudentManagement.calListAvgMark();
                    break;
                case 3:
                    StudentManagement.calListRank();
                    break;
                case 4:
                    StudentManagement.calListAction();
                    break;
                case 5:
                    StudentManagement.displayListStudent();
                    break;
                case 6:
                    StudentManagement.sortStudentByAvgMArk();
                    break;
                case 7:
                    StudentManagement.searchStudentByName();
                    break;
                case 8:
                    StudentManagement.getStudentByRank();
                    break;
                case 9:
                    StudentManagement.getStudentByStatus();
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-10");
            }
        }while (true);
    }
    public static void inputListStudent(Scanner scanner){
        System.out.println("Nhập vào số sinh viên cần nhập");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.inputData(scanner,listStudent);
            listStudent.add(student);
        }
    }
    public static void calListAvgMark(){
        for (Student student : listStudent) {
            student.calAvgMark();
        }
        System.out.println("Đã tính xong điểm trung bình");
    }
    public static void calListRank(){
        for (Student student: listStudent) {
            student.calRank();
        }
        System.out.println("Đã xếp loại xong sinh viên");
    }
    public static  void calListAction(){
        for (Student student: listStudent) {
            student.calStatus();
        }
        System.out.println("Đã tính xong trạng thái sinh viên");
    }
    public static void displayListStudent(){
        System.out.println("THÔNG TIN SINH VÊN");
        for (Student student: listStudent) {
            student.displayData();
        }
    }
    public  static void sortStudentByAvgMArk(){
//        for (int i = 0; i < listStudent.size()-1; i++) {
//            for (int j = i+1; j < listStudent.size() ; j++) {
//                if (listStudent.get(i).getAvgMark()>listStudent.get(j).getAvgMark()){
//                    Student studentTemp = listStudent.get(i);
//                    listStudent.get(i)= listStudent.get(j);
//                    listStudent.get(j)= studentTemp;
//                }
//            }
//            System.out.println("Đã sắp xếp sinh viên tăng dần theo điểm trung bình");
//        }
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
              if (student1.getAvgMark()>student2.getAvgMark()){
                  return 1;
              }else {
                  if (student1.getAvgMark()== student2.getAvgMark()){
                      return 0;
                  }else {
                      return -1;
                  }
              }
            }
        });
        System.out.println("Đã sắp xếp sinh viên tăng dần theo điểm trung bình");
    }
    public static void searchStudentByName(){
        System.out.println("Nhập vào tên sinh viên cần tìm kiếm");
        String name = scanner.nextLine();
        boolean isSearch = false;
        System.out.println("Thông tin các sách tìm kiếm: ");
        for (Student student : listStudent) {
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())){
                student.displayData();
                isSearch= true;
            }
        }
        if (!isSearch){
            System.out.println("Không tìm thấy sách");
        }
    }
    public static void getStudentByRank(){
        if (listStudent.size()==0){
            System.err.println("Không có sinh viên");
            return;
        }
        String[] arrRank = new String[listStudent.size()];
        int arrRankIndex =0;
        for (int i = 0; i < listStudent.size(); i++) {
            boolean check = false;
            for (int j = i+1; j < listStudent.size() ; j++) {
                if ((listStudent.get(j).getRank()).equals(listStudent.get(i).getRank())) {
                    check= true;
                    break;
                }
            }
            if (!check){
                arrRank[arrRankIndex]= listStudent.get(i).getRank();
                arrRankIndex++;
            }
        }
        // Thống kê tần suất xuất hiện
        int[] arrCountRank = new int[arrRankIndex];

        for (int i = 0; i < arrRankIndex; i++) {
            int count = 0;
            for (int j = 0; j < listStudent.size(); j++) {
                if (arrRank[i].equals(listStudent.get(j).getRank())){
                    count++;
                }
            }
            arrCountRank[i]= count;
        }
        for (int i = 0; i < arrRankIndex; i++) {
            System.out.println("Sinh viên xếp loại "+arrRank[i]+" có "+arrCountRank[i]+" sinh viên");
        }
    }
    public static void getStudentByStatus(){
        if (listStudent.size()==0){
            System.err.println("Không có sinh viên");
            return;
        }
        String[] arrAction = new String[listStudent.size()];
        int arrActionIndex =0;
        for (int i = 0; i < listStudent.size(); i++) {
            boolean check = false;
            for (int j = i+1; j < listStudent.size() ; j++) {
                if ((listStudent.get(j).getStatus()).equals(listStudent.get(i).getStatus())) {
                    check= true;
                    break;
                }
            }
            if (!check){
                arrAction[arrActionIndex]= listStudent.get(i).getStatus();
                arrActionIndex++;
            }
        }
        // Thống kê tần suất xuất hiện
        int[] arrCountAction = new int[arrActionIndex];

        for (int i = 0; i < arrActionIndex; i++) {
            int count = 0;
            for (int j = 0; j < listStudent.size(); j++) {
                if (arrAction[i].equals(listStudent.get(j).getStatus())){
                    count++;
                }
            }
            arrCountAction[i]= count;
        }
        for (int i = 0; i < arrActionIndex; i++) {
            System.out.println("Trạng thái sinh viên "+arrAction[i]+" có "+arrCountAction[i]+" sinh viên");
        }
    }
}
