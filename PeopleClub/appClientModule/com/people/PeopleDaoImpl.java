package com.people;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class PeopleDaoImpl implements PeopleDao{
	private Connection connection=ConnectionManager.getConnection();
	@Override
	public void addPeople(PeopleClub p) {
		// TODO Auto-generated method stub
		try {
			CallableStatement call = connection.prepareCall("{?=call peopleid}");
			call.registerOutParameter(1, Types.INTEGER);
			call.execute();
			int idd =  call.getInt(1);
			System.out.println(idd);
			String sql = "insert into PeopleClub values(?,?,?,?,?)";
			
				PreparedStatement ps =  connection.prepareStatement(sql);
				ps.setInt(1, idd);
				ps.setString(2, p.getFname());
				ps.setString(3, p.getLname());
				ps.setDate(4,p.getDob());
				ps.setString(5, p.getCity());
				
				
				int retval=ps.executeUpdate();		// for select use ResultSet rs=executeQuery
				
				if(retval==1)
				{
					
					System.out.println("Person details added successfully");
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	@Override
	public List<PeopleClub> listAllPeople() {
		// TODO Auto-generated method stub
		List <PeopleClub> people=new ArrayList<>();
		try {
			Statement statement=connection.createStatement();
			String sql="select * from PeopleClub";
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				
					PeopleClub p = new PeopleClub(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5));
					people.add(p);
					System.out.println(rs.getInt(1)+" "+rs.getString(2));
					
					
					
				}
				} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return people;
	}
	@Override
	public List<PeopleClub> listMembersByCity(String city) {
		// TODO Auto-generated method stub
		List <PeopleClub> people=new ArrayList<>();
		int ctr=0;
		String sql="select * from peopleclub where city=?";
		try {
			PreparedStatement ps =  connection.prepareStatement(sql);
			ps.setString(1, city);
			
			ResultSet rs =  ps.executeQuery();
			while (rs.next())
			{   ctr++;
				PeopleClub p= new PeopleClub(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5));
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getString(5));
	             people.add(p);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ctr+"people");
		return people;
	
	}
	@Override
	public void updateCity(int id,String city) {
		// TODO Auto-generated method stub
      String sql="Update PeopleClub  Set city=? where pid=?";
      try {
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setInt(2, id);
		ps.setString(1,city);
		int rs=ps.executeUpdate();
		if(rs==1)
		{
			System.out.println("City Updated");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      
	}
	@Override
	public void deletePeople(int pid) {
		// TODO Auto-generated method stub
		String sql="Delete from Peopleclub where pid=?";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1,pid);
			int rs=ps.executeUpdate();
			if(rs==1)
			{
				System.out.println("Member Deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
}
