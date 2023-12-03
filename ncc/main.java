package ncc;

import java.util.Scanner;

import khachhang.KhachHang;

public class main {
    public static void main(String[] args) {
        
        NhaCungCapList danhSachNCC = new NhaCungCapList(100);

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("--------------------MENU--------------------------");
            System.out.println("|   1. Nhập danh sách nhà cung cấp               |");
            System.out.println("|   2. Xuất danh sách nhà cung cấp               |");
            System.out.println("|   3. Thêm một nhà cung cấp mới                 |");
            System.out.println("|   4. Sửa thông tin một nhà cung cấp            |");
            System.out.println("|   5. Xóa một nhà cung cấp                      |");
            System.out.println("|   6. Tìm kiếm nhà cung cấp theo mã             |");
            System.out.println("|   0. Thoát chương trình                        |");
            System.out.println("|   7. Thống kê danh sách nhà cung cấp theo tên  |");
            System.out.println("--------------------------------------------------");

            System.out.println("Nhập lựa chọn của bạn (0-7): ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        danhSachNCC.nhap();
                        break;
                    case 2:
                        System.out.println("Danh sách nhà cung cấp sau khi nhập:");
                        danhSachNCC.xuat();
                        break;
                    case 3:
                        System.out.println("Nhập thông tin nhà cung cấp mới:");
                        System.out.println("Mã nhà cung cấp: ");
                        String maNCC = sc.nextLine();

                        while (!danhSachNCC.isUniqueID(maNCC)) {
                            System.out.println("Mã nhà cung cấp đã tồn tại. Vui lòng nhập lại: ");
                            maNCC = sc.nextLine();
                        }

                        System.out.println("Tên nhà cung cấp: ");
                        String tenNCC = sc.nextLine();
                        System.out.println("Số điện thoại: ");
                        String soDienThoai = sc.nextLine();
                        System.out.println("Địa chỉ: ");
                        String diaChi = sc.nextLine();

                        NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, soDienThoai, diaChi);
                        danhSachNCC.themNhaCungCap(ncc);
                        break;
                        case 4: // Sửa thông tin một nhà cung cấp
                        System.out.println("Nhập mã nhà cung cấp cần sửa: ");
                        maNCC = sc.nextLine();
                        System.out.println("Nhập thông tin nhà cung cấp mới:");
                        System.out.println("Tên nhà cung cấp: ");
                        tenNCC = sc.nextLine();
                        System.out.println("Số điện thoại: ");
                        
                        String sdtNCC;
                        while (true) {
                            sdtNCC = sc.nextLine();
                            if (danhSachNCC.isNumeric(sdtNCC)) { // Change isNumeric to danhSachNCC.isNumeric
                                break;
                            } else {
                                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
                            }
                        }
                    
                        System.out.println("Địa chỉ: ");
                        String diaChiNCC = sc.nextLine();
                    
                        NhaCungCap nccMoi = new NhaCungCap(maNCC, tenNCC, sdtNCC, diaChiNCC);
                        danhSachNCC.suaNhaCungCap(maNCC, nccMoi);
                        break;
                    
                    case 5:
                        System.out.println("Nhập mã nhà cung cấp cần xóa: ");
                        maNCC = sc.nextLine();
                        danhSachNCC.xoaNhaCungCap(maNCC);
                        break;
                    case 6:
                        System.out.println("Nhập mã nhà cung cấp cần tìm: ");
                        maNCC = sc.nextLine();
                        ncc = danhSachNCC.timKiemNhaCungCap(maNCC);

                        if (ncc != null) {
                            System.out.println("Tìm thấy nhà cung cấp có mã " + maNCC + ": " + ncc.toString());
                        } else {
                            System.out.println("Không tìm thấy nhà cung cấp có mã " + maNCC);
                        }
                        break;
                     case 7:
                        System.out.println("Nhập mã nhà cung cấp cần thống kê: ");
                        maNCC = sc.nextLine();
                        danhSachNCC.thongKe(maNCC);
                        break;
                    case 0:
                        System.out.println("Cảm ơn bạn đã sử dụng chương trình. Tạm biệt!");
                        running = false;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                        break;
                }
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                sc.nextLine(); // tránh lặp vô hạn
            }
        }
    }
}
