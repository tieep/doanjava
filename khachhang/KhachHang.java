package khachhang;
public class KhachHang {
    private String MaKhachHang;
    private String HoKhachHang;
    private String TenKhachHang;
    private int SoDienThoaiKH;
    private String DiaChiKH;
    public KhachHang(){
        this.MaKhachHang="";
        this.HoKhachHang="";
        this.TenKhachHang="";
        this.SoDienThoaiKH=0;
        this.DiaChiKH="";
    }
    public KhachHang(String MaKhachHang,String HoKhachHang,String TenKhachHang,int SoDienThoaiKH,String DiaChiKH){
        this.MaKhachHang=MaKhachHang;
        this.HoKhachHang=HoKhachHang;
        this.TenKhachHang=TenKhachHang;
        this.SoDienThoaiKH=SoDienThoaiKH;
        this.DiaChiKH=DiaChiKH;
}
    public String getMaKhachHang(){
        return MaKhachHang;
}   
    public void setMaKhachHang(String MaKhachHang){
      this.MaKhachHang=MaKhachHang;
}
    public String getHoKhachHang(){
    return HoKhachHang;
}
    public void setHoKhachHang(String HoKhachHang){
        this.HoKhachHang=HoKhachHang;
    }
    public String getTenKhachHang(){
        return TenKhachHang;
    }
    public void setTenKhachHang(String TenKhachHang){
        this.TenKhachHang=TenKhachHang;
    }
    public int getSoDienThoaiKH(){
        return SoDienThoaiKH;
    }
    public void setSoDienThoaiKh(int SoDienThoaiKH){
        this.SoDienThoaiKH=SoDienThoaiKH;
    }
    public String getDiaChiKH(){
        return DiaChiKH;
    }
    public void setDiaChiKh(String DiaChiKH){
        this.DiaChiKH=DiaChiKH;
    }
 @Override
public String toString() {
    return "Mã KH: " + MaKhachHang + ", Họ tên: " + HoKhachHang + " " + TenKhachHang + ", SĐT: " + SoDienThoaiKH + ", Địa chỉ: " + DiaChiKH;
}










}
