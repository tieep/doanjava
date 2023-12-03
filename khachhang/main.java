package khachhang;

import java.util.Scanner;

import nhanvien.NhanVien;
import nhanvien.NhanVienList;

public class main {
    public static void main(String[] args) {
        KhachHangList danhSachKH = new KhachHangList(100);
        Scanner sc = new Scanner(System.in);
        boolean running = true; 
        while (running) {
            // Hiển thị menu
            System.out.println("--------------------MENU-------------------------");
            System.out.println("|   1. Nhập danh sách khách hàng                |");
            System.out.println("|   2. Xuất danh sách khách hàng                |");
            System.out.println("|   3. Thêm một khách hàng mới                  |");
            System.out.println("|   4. Sửa thông tin một khách hàng             |");
            System.out.println("|   5. Xóa một khách hàng                       |");
            System.out.println("|   6. Thống kê danh sách khách hàng            |");
            System.out.println("|   7. Tìm kiếm khách hàng theo mã              |");
            System.out.println("|   0. Thoát chương trình                       |");
            System.out.println("-------------------------------------------------");
            System.out.println("Nhập lựa chọn của bạn (0-7): ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();
            
            switch (choice) {
                case 1: ////work
                    
                    danhSachKH.nhap();
                    break;
                case 2: ///work
                   
                    System.out.println("Danh sách khách hàng sau khi nhập:");
                    danhSachKH.xuat();
                    break;
                    case 3:
                    System.out.println("Nhập thông tin khách hàng mới:");
                    System.out.println("Mã khách hàng: ");
                    String maKH = sc.nextLine();
                    System.out.println("Họ khách hàng: ");
                    String hoKH = sc.nextLine();
                    System.out.println("Tên khách hàng");
                    String tenKH = sc.nextLine();
                    System.out.println("SĐT: ");
                    int sdtKH = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Địa chỉ");
                    String diaChiKH = sc.nextLine();
                    KhachHang kh = new KhachHang(maKH, hoKH, tenKH, sdtKH, diaChiKH);
                    danhSachKH.themKhachHang(kh);
                    break;
                
                case 4:
                    System.out.println("Nhập mã khách hàng cần sửa: ");
                    maKH = sc.nextLine();
                    System.out.println("Nhập thông tin khách hàng mới:");
                    System.out.println("Họ khách hàng: ");
                    hoKH = sc.nextLine();
                    System.out.println("Tên khách hàng");
                    tenKH = sc.nextLine();
                    System.out.println("SĐT: ");
                    sdtKH = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Địa chỉ");
                    diaChiKH = sc.nextLine();
                    kh = new KhachHang(maKH, hoKH, tenKH, sdtKH, diaChiKH);
                    danhSachKH.suaKhachHang(maKH, kh);
                    break;
                case 5:
                    System.out.println("Nhập mã khách hàng cần xóa: ");
                    maKH = sc.nextLine();
                    danhSachKH.xoaKhachHang(maKH);
                    break;
                
                    case 6:
                    System.out.println("Nhập tên khách hàng cần thống kê: ");
                    String tenKh = sc.nextLine();
                    danhSachKH.thongKe(tenKh);
                    break;
                
                    case 7:
                    System.out.println("Nhập mã khách hàng cần tìm: ");
                    maKH = sc.nextLine();
                    KhachHang khachHang = danhSachKH.timKiemKhachHang(maKH);
                    if (khachHang != null) {
                        System.out.println("Tìm thấy khách hàng có mã " + maKH + ": " + khachHang.toString());
                    } else {
                        System.out.println("Không tìm thấy khách hàng có mã " + maKH);
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
