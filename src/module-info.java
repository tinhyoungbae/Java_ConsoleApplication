import java.sql.*;  
class ViDuJDBC{  
public static void main(String args[]){  
try{  
// Buoc 1: Tai lop Driver 
Class.forName("com.mysql.jdbc.Driver");  

// Buoc 2: Tao doi tuong Connection    
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/sinhvien","root","123456");  
  
// sihvien la ten co so du lieu, root la username va mat khau la 123456 

// Buoc 3: Tao doi tuong Statement    
Statement stmt=con.createStatement();  
// Buoc 4: Thuc thi truy van    
ResultSet rs=stmt.executeQuery("SELECT * FROM hocphi");  
  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+ rs.getInt(4));
 
// Buoc 5: Dong doi tuong Connection    
con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}  
}  