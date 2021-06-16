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
		sql = "insert into beggar (name, money, hunger, tiredness, level, fight, thief, begCnt, fightEnding, ending) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, beggar.getName());
			psmt.setInt(2, beggar.getMoney());
			psmt.setInt(3, beggar.getHunger());
			psmt.setInt(4, beggar.getTiredness());
			psmt.setInt(5, beggar.getLevel());
			psmt.setInt(6, beggar.getFight());
			psmt.setInt(7, beggar.getThief());
			psmt.setInt(8, beggar.getBegCnt());
			psmt.setInt(9, beggar.getFightEnding());
			psmt.setString(10, beggar.getEnding());
			
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
			b.setFight(rs.getInt("fight"));
			b.setThief(rs.getInt("thief"));
			b.setBegCnt(rs.getInt("begCnt"));
			b.setFightEnding(rs.getInt("fightEnding"));
			b.setEnding(rs.getString("ending"));
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
				b = null;
			}
			else {
			b.setNum(rs.getInt("num"));
			b.setName(rs.getString("name"));
			b.setMoney(rs.getInt("money"));
			b.setHunger(rs.getInt("hunger"));
			b.setTiredness(rs.getInt("tiredness"));
			b.setLevel(rs.getInt("level"));
			b.setFight(rs.getInt("fight"));
			b.setThief(rs.getInt("thief"));
			b.setBegCnt(rs.getInt("begCnt"));
			b.setFightEnding(rs.getInt("fightEnding"));
			b.setEnding(rs.getString("ending"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}
	
	public void saveGame(Beggar beggar) {
		
		sql = "update beggar set money=?, hunger=?, tiredness=?, level=?, fight=?, thief=?, begCnt=?, fightEnding=?, ending=? where num=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, beggar.getMoney());
			psmt.setInt(2, beggar.getHunger());
			psmt.setInt(3, beggar.getTiredness());
			psmt.setInt(4, beggar.getLevel());
			psmt.setInt(5, beggar.getFight());
			psmt.setInt(6, beggar.getThief());
			psmt.setInt(7, beggar.getBegCnt());
			psmt.setInt(8, beggar.getFightEnding());
			psmt.setString(9, beggar.getEnding());
			
			psmt.setInt(10, beggar.getNum());
			
			int r = psmt.executeUpdate();
			
			System.out.println(r + "건 저장되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
