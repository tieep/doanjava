package doanoop;

public class NhanVien {
    private static int soLuongNhanVien = 0;   // thuộc tính static
    private String MaNhanvien;
    private String HoNhanVien;
    private String TenNhanVien;
    private String ChucVu;
    private float Luong;
    public NhanVien(){
this.MaNhanvien="";
this.HoNhanVien="";
this.TenNhanVien="";
this.ChucVu="";
this.Luong=0;
    }
    public NhanVien(String MaNhanvien,String HoNhanVien,String TenNhanVien,String ChucVu,float Luong){
        this.MaNhanvien=MaNhanvien;
        this.HoNhanVien=HoNhanVien;
        this.TenNhanVien=TenNhanVien;
        this.ChucVu=ChucVu;
        this.Luong=Luong;
        soLuongNhanVien++;
    }
    public static int getSoLuongNhanVien() {   /// phương thức static
        return soLuongNhanVien;
    }
    public String getMaNhanVien(){
   return MaNhanvien;
    }
    public void setMaNhanvien(String MaNhanvien){
        this.MaNhanvien=MaNhanvien;
    }
    public String getHoNhanVien(){
        return HoNhanVien;
    }
    public void setHoNhanVien(String HoNhanVien){
        this.HoNhanVien=HoNhanVien;
    }
    public String getTenNhanVien(){
        return TenNhanVien;
    }
    public void setTenNhanVien(String TenNhanVien){
        this.TenNhanVien=TenNhanVien;
    }
    public String getChucVu(){
        return ChucVu;
    }
    public void setChucVu(String ChucVu){
         this.ChucVu=ChucVu;
    }
    public float getLuong(){
        return Luong;
    }
    public void setLuong(float Luong){
        this.Luong=Luong;
    }
    @Override
public String toString() {
    return "Mã NV: " + MaNhanvien + ", Họ tên: " + HoNhanVien + " " + TenNhanVien + ", Chức vụ: " + ChucVu + ", Lương: " + Luong;
}


}
