package doanoop;


import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        NhanVienList danhSachNV = new NhanVienList(100);
        Scanner sc = new Scanner(System.in);
        boolean running = true; // Biến điều kiện để chạy menu
        while (running) {
            // Hiển thị menu
            System.out.println("--------------------MENU------------------------");
            System.out.println("|   1. Nhập danh sách nhân viên                |");
            System.out.println("|   2. Xuất danh sách nhân viên                |");
            System.out.println("|   3. Thêm một nhân viên mới                  |");
            System.out.println("|   4. Sửa thông tin một nhân viên             |");
            System.out.println("|   5. Xóa một nhân viên                       |");
            System.out.println("|   6. Thống kê danh sách nhân viên            |");
            System.out.println("|   7. Tìm kiếm nhân viên theo mã              |");
            System.out.println("|   0. Thoát chương trình                      |");
            System.out.println("------------------------------------------------");
            System.out.println("Nhập lựa chọn của bạn (0-7): ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();
            
            switch (choice) {
                case 1: ////work
                    
                    danhSachNV.nhap();
                    break;
                case 2: ///work
                   
                    System.out.println("Danh sách nhân viên sau khi nhập:");
                    danhSachNV.xuat();
                    break;
                case 3: ///work
                 
                    System.out.println("Nhập thông tin nhân viên mới:");
                    System.out.println("Mã nhân viên: ");
                    String maNV = sc.nextLine();
                    System.out.println("Họ nhan vien: ");
                    String hoNV = sc.nextLine();
                    System.out.println("Tên nhân viên");
                    String tenNV = sc.nextLine();
                    System.out.println("Chức vụ: ");
                    String chucVu = sc.nextLine();
                    System.out.println("mức lương");
                    float luong = sc.nextFloat();
                    sc.nextLine();
                    NhanVien nv = new NhanVien(maNV, hoNV, tenNV, chucVu, luong);
                    danhSachNV.themNhanVien(nv);
                    break;
                case 4: ///work
                    
                    System.out.println("Nhập mã nhân viên cần sửa: ");
                    maNV = sc.nextLine();
                    System.out.println("Nhập thông tin nhân viên mới:");
                    System.out.println("Họ nhan vien: ");
                    hoNV = sc.nextLine();
                    System.out.println("Tên nhân viên");
                    tenNV = sc.nextLine();
                    System.out.println("Chức vụ: ");
                    chucVu = sc.nextLine();
                    System.out.println("mức lương");
                    luong = sc.nextFloat();
                    sc.nextLine();
                    nv = new NhanVien(maNV, hoNV, tenNV, chucVu, luong);
                    danhSachNV.suaNhanVien(maNV, nv);
                    break;
                case 5: //work
                    
                    System.out.println("Nhập mã nhân viên cần xóa: ");
                    maNV = sc.nextLine();
                    danhSachNV.xoaNhanVien(maNV);
                    break;
                case 6:
                System.out.println("Nhập tên nhân viên cần thống kê: ");
                String ten = sc.nextLine();
                danhSachNV.thongKe(ten);
                break;
                case 7:
                   
                    System.out.println("Nhập mã nhân viên cần tìm: ");
                    maNV = sc.nextLine();
                    nv = danhSachNV.timKiemNhanVien(maNV);
                    if (nv != null) {
                        System.out.println("Tìm thấy nhân viên có mã " + maNV + ": " + nv.toString());
                    } else {
                        System.out.println("Không tìm thấy nhân viên có mã " + maNV);
                    }
                    break;
                
                case 0:
                   
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình. Tạm biệt!");
                    running = false;
                    break;
                default:
                 
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    break;
            }
        }
        else {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            sc.nextLine();
            }
        }
    }
}
