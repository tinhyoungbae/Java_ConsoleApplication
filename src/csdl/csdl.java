package csdl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class csdl {
	csdl(){
	}
	public void list_hh() {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/qlbh";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			Statement a = conn.createStatement();
			
			String dshh;
			int i=1;
			do {
				System.out.print("\n1. Nước giải khát");
				System.out.print("\t\t2. Mì gói");
				System.out.print("\n3. Nước suối");
				System.out.print("\t\t\t4. Snack");
				System.out.print("\n5. Sữa");
				System.out.print("\n\tNhập exit để trở về menu chính!");
				System.out.print("\nMời nhập lựa chọn: \t\t");
				dshh = sc.nextLine();
				
				if(dshh.contains("1")) {
					ResultSet dssp1 = a.executeQuery("select distinct tensanpham, giahh from hanghoa, gia where loai='Mì gói'");
					while(dssp1.next()) {
						System.out.println(i +". "+dssp1.getString(1) +"\n\t\t\t"+ dssp1.getFloat(2));
						i++;
					}
					}
				
				if(dshh.contains("2")) {
					ResultSet dssp2 = a.executeQuery("select distinct tensanpham, giahh from hanghoa, gia where loai='Nước giải khát'");
					while(dssp2.next()) {
						System.out.println(i +". " + dssp2.getString(1) +"\n\t\t\t"+ dssp2.getFloat(2));
						i++;
					}
					}
					
					if(dshh.contains("3")) {
					ResultSet dssp3 = a.executeQuery("select distinct tensanpham, giahh from hanghoa, gia where loai='Nước suối'");
					while(dssp3.next()) {
						System.out.println(i +". " + dssp3.getString(1) +"\n\t\t\t"+ dssp3.getFloat(2));
						i++;
					}
					}
					
					
					if(dshh.contains("4")) {
					ResultSet dssp4 = a.executeQuery("select distinct tensanpham, giahh from hanghoa, gia where loai='Snack'");
					while(dssp4.next()) {
						System.out.println(i +". " + dssp4.getString(1) +"\n\t\t\t"+ dssp4.getFloat(2));
						i++;
					}
					}
					
					if(dshh.contains("5")) {
					ResultSet dssp5 = a.executeQuery("select distinct tensanpham, giahh from hanghoa, gia where loai='Sữa'");
					while(dssp5.next()) {
						System.out.println(i +". " + dssp5.getString(1) +"\n\t\t\t"+ dssp5.getFloat(2));
						i++;
					}
					}
					
					
					if(!dshh.contains("4") && !dshh.contains("1") && !dshh.contains("2") && !dshh.contains("3") && !dshh.contains("5") && !dshh.contains("exit")) {
						System.out.print("\nThao tác không hợp lệ!\nVui lòng nhập lại\n");
						}
				
				
			}while(!dshh.contains("exit"));
			if(dshh.contains("exit")) {
				System.out.print("\nĐã thoát khỏi danh sách hàng hóa");
			}
//			sc.close();
			
		}catch (Exception ex) {
		System.out.println("Đã xảy ra lỗi khi kết nối đến mySQL");
	}
	}
	public void insert_hh() {
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n1. Tiếp tục vào quá trình cập nhật hàng hóa");
		System.out.print("\n0. Trở về menu chính");
		System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
		s = sc.nextLine();
		while(!s.contains("0")) {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		String dbURL = "jdbc:mysql://localhost:3306/qlbh";
		String username = "root";
		String password = "";
		Connection conn = DriverManager.getConnection(dbURL, username, password);
		
		System.out.print("\n\t\t\tThêm hàng hóa: ");
		String idhh, tensanpham, loai, hansudung;
		System.out.print("\nMời nhập mã hàng hóa: \t\t\t");
		idhh = sc.nextLine();
		System.out.print("\nMời nhập tên hàng hóa: \t\t\t");
		tensanpham = sc.nextLine();
		System.out.print("\nMời nhập loại hàng hóa: \t\t\t");
		loai = sc.nextLine();
		System.out.print("\nMời nhập hạn sử dụng: \t\t\t");
		hansudung = sc.nextLine();
		PreparedStatement q = conn.prepareStatement("insert into hanghoa(idhh, tensanpham, loai, hansudung) values(?, ?, ?, ?)");
		q.setString(1, idhh);
		q.setString(2, tensanpham);
		q.setString(3, loai);
		q.setString(4, hansudung);
		q.executeUpdate();
		System.out.print("\nĐã cập nhật");
		String a;
		System.out.print("\n\n1. Tiếp tục cập nhật hàng hóa");
		System.out.print("\n0. Dừng cập nhật");
		System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
		a = sc.nextLine();
		if(a.contains("0")) {
			System.out.print("\nĐã dừng cập nhật");
		}
		if(a.contains("0")) {
			break;
		}
	} catch (Exception ex) {
		System.out.println("Đã xảy ra lỗi khi kết nối đến mySQL");
	}
		}
//		sc.close();
	}
	public void delete_hh() {
		String dhh;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n1. Tiếp tục vào quá trình xóa hàng hóa");
		System.out.print("\n0. Trở về menu chính");
		System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
		dhh = sc.nextLine();
		while(!dhh.contains("0")) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/qlbh";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			System.out.print("\n\t\t\tXóa hàng hóa");
			String idhh;
			System.out.print("\nMời nhập mã hàng hóa: \t\t\t\t\t");
			idhh = sc.nextLine();
			PreparedStatement q1 = conn.prepareStatement("delete from hanghoa where idhh=?");
			q1.setString(1, idhh);
			q1.executeUpdate();
			System.out.print("\nĐã cập nhật");
			String x;
			System.out.print("\n\n1. Tiếp tục xóa hàng hóa");
			System.out.print("\n0. Dừng xóa");
			System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
			x = sc.nextLine();
			if(x.contains("0")) {
				System.out.print("\nĐã dừng cập nhật");
			}
			if(x.contains("0")) {
				break;
			}
		} catch (Exception ex) {
			System.out.println("Lỗi không có dữ liệu tồn tại");
		}
		}
//		sc.close();
	}
	public void up_price() {
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n1. Tiếp tục vào quá trình cập nhật giá hàng hóa");
		System.out.print("\n0. Dừng lại");
		System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
		s = sc.nextLine();
		while(!s.contains("0")) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/qlbh";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			System.out.print("\n\t\t\tCập nhật giá bán");
			String idhh; float giahh;
			System.out.print("\nMời nhập mã hàng hóa: \t\t\t\t\t");
			idhh = sc.nextLine();
			System.out.print("\nMời nhập giá mới: \t\t\t\t\t");
			giahh = sc.nextFloat();
			sc.nextLine();
			PreparedStatement nv = conn.prepareStatement("update gia set giahh=? where idhh=?");
			nv.setFloat(1, giahh);
			nv.setString(2, idhh);
			nv.executeUpdate();
			System.out.print("\nĐã cập nhật");
			String b;
			System.out.print("\n\n1. Tiếp tục cập nhật giá bán");
			System.out.print("\n0. Dừng cập nhật");
			System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
			b = sc.nextLine();
			if(b.contains("0")) {
				System.out.print("\nĐã dừng cập nhật");
			}
			if(b.contains("0")) {
				break;
			}
		} catch (Exception ex) {
			System.out.println("Đã xảy ra lỗi khi kết nối đến mySQL");
		}
	}
//		sc.close();
	}
	public void list_nv() {
		String s="";
		Scanner sc = new Scanner(System.in);
		while(s.contains("")) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/qlbh";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			Statement a = conn.createStatement();
			System.out.print("\n\t\t\tDanh sách nhân viên\n");
			int i=1;
			ResultSet dh1 = a.executeQuery("select idnv, tennv, quequan, sdt from nhansu");
			while(dh1.next()) {
				System.out.println(i + "\tID: " + dh1.getString(1) +"\tHọ tên: "+ dh1.getString(2) +"\n\tQuê quán: " +dh1.getString(3) + "\tSĐT: " +dh1.getString(4) + "\n-------------------------------------------------");
				i++;
			}
			String s1;
			System.out.print("\nNhấn phím bất kì để trở về menu Chính");
			s1 = sc.nextLine();
			break;
		} catch (Exception ex) {
			System.out.println("Lỗi không có dữ liệu tồn tại");
		}
		}
//		sc.close();
	}
	
	public void l() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/qtbh";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			Statement a = conn.createStatement();
			System.out.print("\n\t\t\tDanh sách nhân viên\n");
		} catch (Exception ex) {
			System.out.println("Lỗi không có dữ liệu tồn tại");
		}
		}
	
	public void insert_nv() {
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n1. Tiếp tục vào quá trình thêm nhân viên");
		System.out.print("\n0. Dừng lại");
		System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
		s = sc.nextLine();
		while(!s.contains("0")) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/qlbh";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			
			System.out.print("\n\t\t\tThêm nhân viên: ");
			String idnv, tennv, quequan, sdt;
			System.out.print("\nMời nhập mã nhân viên mới: \t\t\t");
			idnv = sc.nextLine();
			System.out.print("\nMời nhập tên nhân viên mới: \t\t\t");
			tennv = sc.nextLine();
			System.out.print("\nMời nhập quê quán: \t\t\t\t");
			quequan = sc.nextLine();
			System.out.print("\nMời nhập SĐT: \t\t\t\t\t");
			sdt = sc.nextLine();
			PreparedStatement nv = conn.prepareStatement("insert into nhansu(idnv, tennv, quequan, sdt) values(?, ?, ?, ?)");
			nv.setString(1, idnv);
			nv.setString(2, tennv);
			nv.setString(3, quequan);
			nv.setString(4, sdt);
			nv.executeUpdate();
			System.out.print("\nĐã cập nhật thành công");
			String b;
			System.out.print("\n\n1. Tiếp tục cập nhật nhân viên");
			System.out.print("\n0. Dừng cập nhật");
			System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
			b = sc.nextLine();
			if(b.contains("0")) {
				System.out.print("\nĐã dừng cập nhật");
			}
			if(b.contains("0")) {
				break;
			}
		} catch (Exception ex) {
			System.out.println("Đã xảy ra lỗi khi kết nối đến mySQL");
		}
	}
//		sc.close();
	}
	public void delete_nv() {
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n1. Tiếp tục vào quá trình xóa nhân viên");
		System.out.print("\n0. Dừng lại");
		System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
		s = sc.nextLine();
		while(!s.contains("0")) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/qlbh";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			//Statement a = conn.createStatement();
			
			System.out.print("\n\t\t\tXóa nhân viên");
			String idnv;
			System.out.print("\nMời nhập mã nhân viên: \t\t\t\t\t");
			idnv = sc.nextLine();
			PreparedStatement nv1 = conn.prepareStatement("delete from nhansu where idnv=?");
			nv1.setString(1, idnv);
			nv1.executeUpdate();
			System.out.print("\nĐã cập nhật thành công");
			String b;
			System.out.print("\n\n1. Tiếp tục xóa nhân viên");
			System.out.print("\n0. Dừng cập nhật");
			System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
			b = sc.nextLine();
			if(b.contains("0")) {
				System.out.print("\nĐã dừng cập nhật");
			}
			if(b.contains("0")) {
				break;
			}
		} catch (Exception ex) {
			System.out.println("Lỗi không có dữ liệu tồn tại");
		}
		}
//		sc.close();
	}
	public void his_order() {
		String s="";
		Scanner sc = new Scanner(System.in);
		while(s.contains("")) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/qlbh";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			Statement a = conn.createStatement();
			System.out.print("\n\t\t\tLịch sử đơn hàng\n\n");
			int i=1;
			ResultSet dh1 = a.executeQuery("select tensanpham, loai, sl, diachi, sdt from hanghoa, hanggui where hanghoa.idhh=hanggui.idhh");
			while(dh1.next()) {
				System.out.println("STT: "+i +"\n" +"Tên sản phẩm: "+ dh1.getString(1) +"\n"+ "Số lượng: " + dh1.getString(2) +"\n"+"Loại: " + dh1.getInt(3)
				+"\n"+ "SĐT: " + dh1.getString(5) +"\n"+ "Địa chỉ: " + dh1.getString(4)
				+"\n------------------------------------------------------------");
				i++;
			}
			String s1;
			System.out.print("\nNhấn phím bất kì để trở về menu Chính");
			s1 = sc.nextLine();
			break;
		} catch (Exception ex) {
			System.out.println("Lỗi không có dữ liệu tồn tại");
		}
		}
//		sc.close();
	}
	public void cre_order() {
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n1. Tiếp tục vào quá trình tạo đơn hàng");
		System.out.print("\n0. Dừng lại");
		System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
		s = sc.nextLine();
		while(!s.contains("0")) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/qlbh";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			//Statement a = conn.createStatement();
			
			System.out.print("\n\t\tTạo đơn hàng: \n");
			String idhh, diachi, sdt;
			int sl;
			System.out.print("Mời nhập mã hàng hóa: \t\t\t");
			idhh = sc.nextLine();
			System.out.print("\nMời số lượng: \t\t\t");
			sl = sc.nextInt();
			sc.nextLine();
			System.out.print("\nMời nhập địa chỉ: \t\t\t");
			diachi = sc.nextLine();
			System.out.print("\nMời nhập SĐT: \t\t\t");
			sdt = sc.nextLine();
			PreparedStatement q = conn.prepareStatement("insert into hanggui(idhh, sl, diachi, sdt) values(?, ?, ?, ?)");
			q.setString(1, idhh);
			q.setInt(2, sl);
			q.setString(3, diachi);
			q.setString(4, sdt);
			q.executeUpdate();
			
			System.out.print("\nĐã cập nhật");
			
			String b;
			System.out.print("\n\n1. Tiếp tục tạo đơn hàng");
			System.out.print("\n0. Dừng cập nhật");
			System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
			b = sc.nextLine();
			if(b.contains("0")) {
				System.out.print("\nĐã dừng cập nhật");
			}
			if(b.contains("0")) {
				break;
			}
		} catch (Exception ex) {
			System.out.println("Đã xảy ra lỗi khi kết nối đến mySQL");
		}
	}
//	sc.close();
}
	public void up_salary() {
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n1. Tiếp tục vào quá trình cập nhật Lương");
		System.out.print("\n0. Dừng lại");
		System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
		s = sc.nextLine();
		while(!s.contains("0")) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/qlbh";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			
			System.out.print("\n\t\t\tCập nhật Lương ");
			String idl; float luongchuan;
			System.out.print("\nMời nhập mã Lương: \t\t\t");
			idl = sc.nextLine();
			System.out.print("\nMời nhập lương: \t\t\t");
			luongchuan = sc.nextFloat();
			sc.nextLine();
			PreparedStatement nv = conn.prepareStatement("update luong set luongchuan=? where idl=?");
			nv.setFloat(1, luongchuan);
			nv.setString(2, idl);
			nv.executeUpdate();
			System.out.print("\nĐã cập nhật");
			String b;
			System.out.print("\n\n1. Tiếp tục cập nhật Lương");
			System.out.print("\n0. Dừng cập nhật");
			System.out.print("\n\nMời nhập lựa chọn: \t\t\t");
			b = sc.nextLine();
			if(b.contains("0")) {
				System.out.print("\nĐã dừng cập nhật");
			}
			if(b.contains("0")) {
				break;
			}
		} catch (Exception ex) {
			System.out.println("Đã xảy ra lỗi khi kết nối đến mySQL");
		}
	}
}
	public static void main(String[] args) {
		csdl db = new csdl();
		Scanner sc = new Scanner(System.in);
		String s;
		try {
		do {
			System.out.print("\n\n\t\tQuản lý bán hàng");
			System.out.print("\n0. Danh sách hàng hóa");
			System.out.print("\t\t1. Thêm hàng hóa");
			System.out.print("\n2. Xóa hàng hóa");
			System.out.print("\t\t\t3. Cập nhật giá bán");
			System.out.print("\n4. Danh sách nhân viên");
			System.out.print("\t\t5. Thêm nhân viên");
			System.out.print("\n6. Xóa nhân viên");
			System.out.print("\t\t7. Lịch sử đơn hàng");
			System.out.print("\n8. Tạo đơn hàng mới");
			System.out.print("\t\t9. Cập nhật Lương");
			System.out.print("\n\t\tNhập exit để tắt chương trình!");
		System.out.print("\nMời nhập lựa chọn: \t\t\t");
		s=sc.nextLine();
		
		if(s.contains("0")) {
			db.list_hh();
		}
		
		if(s.contains("1")) {
			db.insert_hh();
		}
		
		if(s.contains("2")) {
			db.delete_hh();
		}
		
		if(s.contains("3")) {
			db.up_price();
		}
		
		if(s.contains("4")) {
			db.l();
		}
		
		if(s.contains("5")) {
			db.insert_nv();
		}
		
		if(s.contains("6")) {
			db.delete_nv();
		}
		
		if(s.contains("7")) {
			db.his_order();
		}
		
		if(s.contains("8")) {
			db.cre_order();
		}
		
		
		if(s.contains("9")) {
			db.up_salary();
		}
		if(!s.contains("4") && !s.contains("1") && !s.contains("2") && !s.contains("3") && !s.contains("5") && !s.contains("6") 
				&& !s.contains("7") && !s.contains("8") && !s.contains("9") && !s.contains("0") && s.contains("0")) {
			System.out.print("\nThao tác không hợp lệ!\nVui lòng nhập lại\n");
			}
		}while(!s.contains("exit"));
		if(s.contains("exit")) {
			System.out.print("\n\t\tĐã dừng chương trình");
		}
	}catch(Exception e) {
		
	}
	}
}