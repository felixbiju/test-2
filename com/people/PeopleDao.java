package com.people;

import java.util.List;


public interface PeopleDao {
	public void addPeople(PeopleClub p);
	public List<PeopleClub> listAllPeople();
	public void deletePeople(int pid);
	public void updateCity(int id,String city);
	public List<PeopleClub> listMembersByCity(String city);
	
}
