package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BeggarDAO extends DAO {
	
	ArrayList<Beggar> beggar = new ArrayList<>();
	
	String sql;
	PreparedStatement psmt;
	ResultSet rs;
	
	public void newBeggar(Beggar beggar) {
		sql = "insert into beggar (name, money, hunger, tiredness, level) values(?, ?, ?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, beggar.getName());
			psmt.setInt(2, beggar.getMoney());
			psmt.setInt(3, beggar.getHunger());
			psmt.setInt(4, beggar.getTiredness());
			psmt.setInt(5, beggar.getLevel());
			
			int r = psmt.executeUpdate();
			
			System.out.println("거지 " + r + "명이 생성되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	
	public ArrayList<Beggar> beggarList() {
		ArrayList<Beggar> array = new ArrayList<>();
		sql = "select * from beggar";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
			Beggar b = new Beggar();
			b.setNum(rs.getInt("num"));
			b.setName(rs.getString("name"));
			b.setMoney(rs.getInt("money"));
			b.setHunger(rs.getInt("hunger"));
			b.setTiredness(rs.getInt("tiredness"));
			b.setLevel(rs.getInt("level"));
			array.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
	}
	
	
	
	
	public Beggar selectOne(int num) {
		Beggar b = new Beggar();
		sql = "select * from beggar where num=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, num);
			
			rs = psmt.executeQuery();
			
			if (!rs.next()) {
				System.out.println("없는 번호입니다.");
			}
			else {
			b.setNum(rs.getInt("num"));
			b.setName(rs.getString("name"));
			b.setMoney(rs.getInt("money"));
			b.setHunger(rs.getInt("hunger"));
			b.setTiredness(rs.getInt("tiredness"));
			b.setLevel(rs.getInt("level"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}
	
	public void saveGame(Beggar beggar) {
		
		sql = "update beggar set money=?, hunger=?, tiredness=?, level=? where num=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, beggar.getMoney());
			psmt.setInt(2, beggar.getHunger());
			psmt.setInt(3, beggar.getTiredness());
			psmt.setInt(4, beggar.getLevel());
			
			psmt.setInt(5, beggar.getNum());
			
			int r = psmt.executeUpdate();
			
			System.out.println(r + "건 저장되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}