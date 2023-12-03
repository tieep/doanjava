package khachhang;

import java.util.Scanner;
import khachhang.KhachHang;
import nhanvien.DadOfInterFace;
public interface PhoneNumberValidator {
    boolean isNumeric(String phoneNumber);
}
public class KhachHangList implements DadOfInterFace, PhoneNumberValidator {

    private KhachHang[] arr;
    private int size;

    public KhachHangList() {

    }

    public KhachHangList(int capacity) {
        arr = new KhachHang[capacity];
        size = 0;
    }

    public KhachHang[] getArr() {
        return arr;
    }

    public void setArr(KhachHang[] newArr) {
        arr = newArr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int newSize) {
        size = newSize;
    }

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isUniqueID(String maKh) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].getMaKhachHang().equals(maKh)) {
                return false; // Mã khách hàng trùng lặp
            }
        }
        return true; // Mã khách hàng không trùng lặp
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng khách hàng: ");
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

        int currentSize = getSize(); // Lưu lại kích thước hiện tại của mảng
        newSize += currentSize; // Cộng thêm vào để có kích thước mới

        KhachHang[] tempArr = getArr(); // Lưu lại mảng hiện tại

        // Tạo mảng mới với kích thước mới
        setArr(new KhachHang[newSize]);

        // Sao chép dữ liệu từ mảng cũ sang mảng mới
        System.arraycopy(tempArr, 0, getArr(), 0, currentSize);

        // Cập nhật kích thước mới
        setSize(newSize);

        for (int i = currentSize; i < newSize; i++) {
            System.out.println("Nhập thông tin khách hàng thứ " + (i + 1) + ":");
            System.out.println("Mã khách hàng: ");
            String maKh = sc.nextLine();

            while (!isUniqueID(maKh)) {
                System.out.println("Mã khách hàng đã tồn tại. Vui lòng nhập lại: ");
                maKh = sc.nextLine();
            }

            System.out.println("Họ khách hàng: ");
            String hoKh = sc.nextLine();
            System.out.println("Tên khách hàng: ");
            String tenKh = sc.nextLine();
            System.out.println("Số điện thoại: ");

            int sdtKH;
            while (true) {
                try {
                    sdtKH = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
                }
            }

            System.out.println("Địa chỉ: ");
            String diaChiKh = sc.nextLine();

            getArr()[i] = new KhachHang(maKh, hoKh, tenKh, sdtKH, diaChiKh);
        }
    }

    public void xuat() {
        System.out.println("------------------Danh sách khách hàng----------------");
        System.out.format("%-15s|%-20s|%-15s|%-15s|%10s%n", "Mã khách hàng", "Họ khách hàng", "Tên khách hàng", "SĐT", "Địa chỉ");
        for (int i = 0; i < size; i++) {
            System.out.format("%-15s|%-20s|%-15s|%-15s|%10s%n", arr[i].getMaKhachHang(), arr[i].getHoKhachHang(),
                    arr[i].getTenKhachHang(), arr[i].getSoDienThoaiKH(), arr[i].getDiaChiKH());
        }
    }

    public KhachHang timKiemKhachHang(String maKh) {
        if (maKh != null) {
            for (int i = 0; i < size; i++) {
                if (arr[i].getMaKhachHang().equals(maKh)) {
                    return arr[i];
                }
            }
        }
        return null;
    }

    public void themKhachHang(KhachHang kh) {
        int currentSize = getSize(); // Lấy kích thước hiện tại của mảng

        if (currentSize < arr.length) {
            arr[currentSize] = kh;
            setSize(currentSize + 1);
        } else {
            System.out.println("Danh sách đầy, không thể thêm mới khách hàng.");
        }
    }

    public void suaKhachHang(String maKh, KhachHang khMoi) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getMaKhachHang().equals(maKh)) {
                arr[i] = khMoi;
                System.out.println("Đã cập nhật thông tin khách hàng.");
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng có mã " + maKh);
    }

    public void xoaKhachHang(String maKh) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getMaKhachHang().equals(maKh)) {
                // Di chuyển các phần tử sau về trước để xóa
                for (int j = i; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                size--;
                System.out.println("Đã xóa khách hàng có mã " + maKh);
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng có mã " + maKh);
    }

    public void thongKe(String ten) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            String tenKH = arr[i].getTenKhachHang();

            if (tenKH.equals(ten)) {

                count++;
            }
        }
        System.out.println("Tên khách hàng: " + ten + ", Số lượng: " + count);
    }
}
