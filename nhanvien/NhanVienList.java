package nhanvien;
import java.util.ArrayList;
import java.util.Scanner;

import nhanvien.NhanVien;
interface UniqueIDValidator {
    boolean isUniqueID(String maNV);
}
interface NumericInputValidator {
    boolean isNumeric(String input);
}
public interface SalaryValidator {
    boolean isSalaryValid(String salary);
}

public interface DadOfInterFace extends UniqueIDValidator, NumericInputValidator {

    
}

public class NhanVienList implements DadOfInterFace,SalaryValidator {
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
        int newSize = 0;
    
        while (true) {
            String input = sc.nextLine();
            if (isNumeric(input)) {
                newSize = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Vui lòng nhập số.");
            }
        }
    
        int currentSize = getSize();  // Lưu lại kích thước hiện tại của mảng
        newSize += currentSize;  // Cộng thêm vào để có kích thước mới
    
        NhanVien[] tempArr = getArr();  // Lưu lại mảng hiện tại
    
        // Tạo mảng mới với kích thước mới
        setArr(new NhanVien[newSize]);
    
        // Sao chép dữ liệu từ mảng cũ sang mảng mới
        System.arraycopy(tempArr, 0, getArr(), 0, currentSize);
    
        // Cập nhật kích thước mới
        setSize(newSize);
        for (int i = currentSize; i < newSize; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
            System.out.println("Mã nhân viên: ");
            String maNV = sc.nextLine();
            while (!isUniqueID(maNV)) {
                System.out.println("Mã nhân viên đã tồn tại. Vui lòng nhập lại: ");
                maNV = sc.nextLine();
            }
            System.out.println("Họ nhân viên: ");
            String hoNV = sc.nextLine();
            System.out.println("Tên nhân viên: ");
            String tenNV = sc.nextLine();
            System.out.println("Chức vụ: ");
            String chucVu = sc.nextLine();
            System.out.println("Mức lương: ");
            String salary = sc.nextLine();
            while (!isSalaryValid(salary)) {
                System.out.println("Lương không hợp lệ. Vui lòng nhập lại: ");
                salary = sc.nextLine();
            }
            float luong = Float.parseFloat(salary);
            getArr()[i] = new NhanVien(maNV, hoNV, tenNV, chucVu, luong);
        }
    }
    public void xuat() {
        System.out.println("------------------Danh sách nhân viên----------------");
        System.out.format("%-15s|%-20s|%-15s|%-15s|%10s%n", "Mã nhân viên", "Họ nhân viên", "Tên nhân viên", "Chức vụ", "Mức lương");
        for (int i = 0; i < size; i++) {
            System.out.format("%-15s|%-20s|%-15s|%-15s|%10.2f%n", arr[i].getMaNhanVien(), arr[i].getHoNhanVien(), arr[i].getTenNhanVien(), arr[i].getChucVu(), arr[i].getLuong());
        }
        // Show static
        int staticnumofstaff = NhanVien.getSoLuongNhanVien();
        System.out.println("Số lượng nhân viên: " + staticnumofstaff);
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
        int currentSize = getSize();  // Lấy kích thước hiện tại của mảng
  
        if (currentSize < arr.length) {
            arr[currentSize] = nv;  
            setSize(currentSize + 1);  
        } else {
            int newSize = arr.length * 2; // Tăng kích thước mảng lên gấp đôi
            NhanVien[] newArr = new NhanVien[newSize];
            System.arraycopy(arr, 0, newArr, 0, currentSize);
            newArr[currentSize] = nv;  // Thêm nhân viên mới vào vị trí cuối cùng của mảng mới
            arr = newArr;
            setSize(currentSize + 1);  // Cập nhật kích thước mới
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
        
        
    




