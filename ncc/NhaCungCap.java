package ncc;

public class NhaCungCap {
     ///private static int soLuongNhaCungCap = 0; ===>lỗi
    private String maNhaCungCap;
    private String tenNhaCungCap;
    private String soDienThoai;
    private String diaChi;

    public NhaCungCap() {
        this.maNhaCungCap = "";
        this.tenNhaCungCap = "";
        this.soDienThoai = "";
        this.diaChi = "";
    }

    public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String soDienThoai, String diaChi) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
       // soLuongNhaCungCap++;
    }
/*  public static int getSoLuongNhaCungCap() {
        return soLuongNhaCungCap;             //// hiện tại biến static đang k work
    } */
   
    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Mã NCC: " + maNhaCungCap + ", Tên NCC: " + tenNhaCungCap + ", Số điện thoại: " + soDienThoai + ", Địa chỉ: " + diaChi;
    }
}


