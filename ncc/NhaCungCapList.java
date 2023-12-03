package ncc;

import java.util.Scanner;
import khachhang.PhoneNumberValidator;
import nhanvien.DadOfInterFace;
;
public class NhaCungCapList implements DadOfInterFace, PhoneNumberValidator {
    private NhaCungCap[] arr;
    private int size;

    public NhaCungCapList() {
    }

    public NhaCungCapList(int capacity) {
        arr = new NhaCungCap[capacity];
        size = 0;
    }

    public NhaCungCap[] getArr() {
        return arr;
    }

    public void setArr(NhaCungCap[] newArr) {
        arr = newArr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int newSize) {
        size = newSize;
    }

    @Override
    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isUniqueID(String maNCC) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].getMaNhaCungCap().equals(maNCC)) {
                return false; // Mã nhà cung cấp trùng lặp
            }
        }
        return true; // Mã nhà cung cấp không trùng lặp
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng nhà cung cấp: ");
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

        NhaCungCap[] tempArr = getArr(); // Lưu lại mảng hiện tại

        // Tạo mảng mới với kích thước mới
        setArr(new NhaCungCap[newSize]);

        // Sao chép dữ liệu từ mảng cũ sang mảng mới
        System.arraycopy(tempArr, 0, getArr(), 0, currentSize);

        // Cập nhật kích thước mới
        setSize(newSize);
        for (int i = currentSize; i < newSize; i++) {
            System.out.println("Nhập thông tin nhà cung cấp thứ " + (i + 1) + ":");
            System.out.println("Mã nhà cung cấp: ");
            String maNCC = sc.nextLine();

            while (!isUniqueID(maNCC)) {
                System.out.println("Mã nhà cung cấp đã tồn tại. Vui lòng nhập lại: ");
                maNCC = sc.nextLine();
            }

            System.out.println("Tên nhà cung cấp: ");
            String tenNCC = sc.nextLine();
            System.out.println("Số điện thoại: ");

            String sdtNCC;
            while (true) {
                sdtNCC = sc.nextLine();
                if (isNumeric(sdtNCC)) {
                    break;
                } else {
                    System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
                }
            }

            System.out.println("Địa chỉ: ");
            String diaChiNCC = sc.nextLine();

            arr[i] = new NhaCungCap(maNCC, tenNCC, sdtNCC, diaChiNCC);
        }
    }

    public void xuat() {
        System.out.println("------------------Danh sách nhà cung cấp----------------");
        System.out.format("%-15s|%-20s|%-15s|%-15s%n", "Mã NCC", "Tên NCC", "SĐT", "Địa chỉ");
        for (int i = 0; i < size; i++) {
            System.out.format("%-15s|%-20s|%-15s|%-15s%n", arr[i].getMaNhaCungCap(), arr[i].getTenNhaCungCap(),
                    arr[i].getSoDienThoai(), arr[i].getDiaChi());
        }
        // Show static
        // int staticNumOfSuppliers = NhaCungCap.getSoLuongNhaCungCap();
        // System.out.println("Số lượng nhà cung cấp: " + staticNumOfSuppliers);
    }

    public NhaCungCap timKiemNhaCungCap(String maNCC) {
        if (maNCC != null) {
            for (int i = 0; i < size; i++) {
                if (arr[i].getMaNhaCungCap().equals(maNCC)) {
                    return arr[i];
                }
            }
        }
        return null;
    }

    public void themNhaCungCap(NhaCungCap ncc) {
        int currentSize = getSize(); // Lấy kích thước hiện tại của mảng

        if (currentSize < arr.length) {
            arr[currentSize] = ncc; // Thêm nhà cung cấp mới vào vị trí cuối cùng của mảng hiện tại
            setSize(currentSize + 1); // Cập nhật kích thước mới
        } else {
            int newSize = arr.length * 2; // Tăng kích thước mảng lên gấp đôi
            NhaCungCap[] newArr = new NhaCungCap[newSize];
            System.arraycopy(arr, 0, newArr, 0, currentSize);
            newArr[currentSize] = ncc; // Thêm nhà cung cấp mới vào vị trí cuối cùng của mảng mới
            arr = newArr;
            setSize(currentSize + 1); // Cập nhật kích thước mới
        }
    }

    public void suaNhaCungCap(String maNCC, NhaCungCap nccMoi) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getMaNhaCungCap().equals(maNCC)) {
                arr[i] = nccMoi;
                System.out.println("Đã cập nhật thông tin nhà cung cấp.");
                return;
            }
        }
        System.out.println("Không tìm thấy nhà cung cấp có mã " + maNCC);
    }

    public void xoaNhaCungCap(String maNCC) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getMaNhaCungCap().equals(maNCC)) {
                // Di chuyển các phần tử sau về trước để xóa
                for (int j = i; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                size--;
                System.out.println("Đã xóa nhà cung cấp có mã " + maNCC);
                return;
            }
        }
        System.out.println("Không tìm thấy nhà cung cấp có mã " + maNCC);
    }

     public void thongKe(String ten) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            String tenNCC = arr[i].getTenNhaCungCap();

            if (tenNCC.equals(ten)) {

                count++;
            }
        }
        System.out.println("Tên nhà cung cấp: " + ten + ", Số lượng: " + count);
    }
}
