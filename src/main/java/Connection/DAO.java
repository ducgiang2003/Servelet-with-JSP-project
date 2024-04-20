package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
public static List<Entities> show(Connection con) throws SQLException
{
	String querry = "select * from nhanvien";
	PreparedStatement PS =con.prepareStatement(querry);
	ResultSet RS = PS.executeQuery();
	List<Entities> list=new ArrayList();
	while(RS.next())
	{
		Entities et = new Entities(RS.getInt("id"),RS.getInt("year"),RS.getString("name"),RS.getString("adress"));
		list.add(et);
	}
	return list;
}
public static void printList(Connection con ) throws SQLException
{
	List list = show(con);
	for(int i =0 ;i<list.size();i++)
	{
		Entities et =(Entities) list.get(i);
		System.out.println(et.toString());
	}
}
public static void deleteList(Connection con,int id) throws SQLException
{
	String querry = "delete from nhanvien where id =?";
	PreparedStatement PS = con.prepareStatement(querry);
	PS.setInt(1, id);
	PS.executeUpdate();
}
public static void insertList(Connection con,Entities et ) throws SQLException
{
	//Luu y querry phai dung thu tu trong bang co so du lieu neu khong thi se xay ra hien tuong loi sql syntax
	String query = "insert into nhanvien set id=?,year=?,name=?,adress=? ";
	PreparedStatement PS= con.prepareStatement(query);
	//id o vi tri thu 1 , name o vi tri thu 2 con adress o vi tri thu 3 
	PS.setInt(1,et.getId());
	PS.setString(3, et.getHoTen());
	PS.setInt(2,et.getNamSinh());
	PS.setString(4,et.getQueQuan());
	PS.executeUpdate();
}
public static void updateList(Connection con ,Entities et) throws SQLException
{
	String query = "update nhanvien set name =? , year=?,adress=?  where id=?";
	PreparedStatement PS = con.prepareStatement(query);
	//So thu thu trong PS.set lien quan den query 
	//name luc nay o vi tri thu 1 , year o vi tri  thu 2 , adress o vi tri thu 3 
	PS.setInt(4,et.getId());
	PS.setInt(2, et.getNamSinh());
	PS.setString(1,et.getHoTen());
	PS.setString(3, et.getQueQuan());
	PS.executeUpdate();
}
public static Entities findbyId(Connection con,int id) throws SQLException
{
	String query ="select * from nhanvien where id =?";
	PreparedStatement PS = con.prepareStatement(query);
	PS.setInt(1, id);
	ResultSet RS = PS.executeQuery();
	while(RS.next())
	{
		Entities et = new Entities(RS.getInt("id"),RS.getInt("year"),RS.getString("name"),RS.getString("adress"));
		return et;
	}
	return null;
}
public static void main(String[] args) {
	try {
		Connection con = ConnectionPool.getConnection();
		printList(con);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
