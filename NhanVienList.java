package doanoop;
import java.util.ArrayList;
import java.util.Scanner;
interface UniqueIDValidator {
    boolean isUniqueID(String maNV);
}
interface NumericInputValidator {
    boolean isNumeric(String input);
}
public interface SalaryValidator {
    boolean isSalaryValid(String salary);
}

public class NhanVienList implements UniqueIDValidator,NumericInputValidator,SalaryValidator {
    private NhanVien[] arr;
    private int size;

    public NhanVienList() {

    }

    public NhanVienList(int capacity) {
        arr = new NhanVien[capacity];
        size = 0;
    }

    public NhanVien[] getArr() {
        return arr;
    }

    public void setArr(NhanVien[] newArr) {
        arr = newArr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int newSize) {
        size = newSize;
    }
    public boolean isNumeric(String input) {
        return input.matches("\\d+");
    }
    @Override
    public boolean isUniqueID(String maNV) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].getMaNhanVien().equals(maNV)) {
                return false; // Mã nhân viên trùng lặp
            }
        }
        return true; // Mã nhân viên không trùng lặp
    }
    @Override
    public boolean isSalaryValid(String salary) {
        // Kiểm tra xem chuỗi chứa số lương có hợp lệ không (ví dụ: không âm)
        try {
            float salaryValue = Float.parseFloat(salary);
            return salaryValue >= 0; // Có thể điều chỉnh điều kiện kiểm tra tùy theo yêu cầu
        } catch (NumberFormatException e) {
            return false; // Nếu không chuyển đổi được thành số, trả về false
        }
    }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng nhân viên: ");
        while (true) {
            String input = sc.nextLine();
            if (isNumeric(input)) {
                size = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Vui lòng nhập số.");
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
            System.out.println("Mã nhân viên: ");
            String maNV = sc.nextLine();
            while (!isUniqueID(maNV)) {
                System.out.println("Mã nhân viên đã tồn tại. Vui lòng nhập lại: ");
                maNV = sc.nextLine();
            }
            System.out.println("Họ nhan vien: ");
            String hoNV = sc.nextLine();
            System.out.println("Tên nhân viên");
            String tenNV = sc.nextLine();
            System.out.println("Chức vụ: ");
            String chucVu = sc.nextLine();
            System.out.println("mức lương");
            String salary = sc.nextLine();
            while (!isSalaryValid(salary)) {
                System.out.println("Lương không hợp lệ. Vui lòng nhập lại: ");
                salary = sc.nextLine();
            }
            float luong = Float.parseFloat(salary);
            arr[i] = new NhanVien(maNV, hoNV, tenNV, chucVu, luong);
        }
    }

    public void xuat() {
        System.out.println("------------------Danh sách nhân viên----------------");
        System.out.format("%-15s|%-20s|%-15s|%-15s|%10s%n", "Mã nhân viên", "Họ nhân viên", "Tên nhân viên", "Chức vụ", "Mức lương");
        for (int i = 0; i < size; i++) {
            System.out.format("%-15s|%-20s|%-15s|%-15s|%10.2f%n", arr[i].getMaNhanVien(), arr[i].getHoNhanVien(), arr[i].getTenNhanVien(), arr[i].getChucVu(), arr[i].getLuong());
        }
        /// show static
       int staticnumofstaff = NhanVien.getSoLuongNhanVien();
System.out.println("số lượng nhân viên: "+staticnumofstaff);
    }
    
    

    public NhanVien timKiemNhanVien(String maNV) {
        if (maNV != null) {
            for (int i = 0; i < size; i++) {
                if (arr[i].getMaNhanVien().equals(maNV)) {
                    return arr[i];
                }
            }
        }
        return null;
    }
    

    public void themNhanVien(NhanVien nv) {
        if (size < arr.length) {
            arr[size++] = nv;
        } else {
            System.out.println("Danh sách đầy, không thể thêm mới nhân viên.");
        }
    }

    public void suaNhanVien(String maNV, NhanVien nvMoi) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getMaNhanVien().equals(maNV)) {
                arr[i] = nvMoi;
                System.out.println("Đã cập nhật thông tin nhân viên.");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên có mã " + maNV);
    }

    public void xoaNhanVien(String maNV) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getMaNhanVien().equals(maNV)) {
                // Di chuyển các phần tử sau về trước để xóa
                for (int j = i; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                size--;
                System.out.println("Đã xóa nhân viên có mã " + maNV);
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên có mã " + maNV);
    }
 // ở hàm thống kê : In số lượng nhân viên, tổng lương, trung bình lương, ...
    
 public void thongKe(String ten) {
    int count = 0;
    for (int i = 0; i < size; i++) {
        String tenNV = arr[i].getTenNhanVien();
        
        if (tenNV.equals(ten)) {
            
            count++;
        }
    }
    System.out.println("Tên nhân viên: " + ten + ", Số lượng: " + count);
}

        }
        
        
    




