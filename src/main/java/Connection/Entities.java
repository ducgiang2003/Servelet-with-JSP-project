package Connection;

public class Entities {
private int id,namSinh;
private String hoTen,queQuan;
@Override
public String toString() {
	return "Entities [id=" + id + ", namSinh=" + namSinh + ", hoTen=" + hoTen + ", queQuan=" + queQuan + "]";
}
public Entities(int id, int namSinh, String hoTen, String queQuan) {
	
	this.id = id;
	this.namSinh = namSinh;
	this.hoTen = hoTen;
	this.queQuan = queQuan;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getNamSinh() {
	return namSinh;
}
public void setNamSinh(int namSinh) {
	this.namSinh = namSinh;
}
public String getHoTen() {
	return hoTen;
}
public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public String getQueQuan() {
	return queQuan;
}
public void setQueQuan(String queQuan) {
	this.queQuan = queQuan;
}


}
