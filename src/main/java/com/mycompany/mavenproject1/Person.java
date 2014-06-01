/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author bartek
 */
public class Person {
    private static final long serialVersionUID = 1L;

	private int Id=1;
	private String Name="lol";
	private String Link="link";
	private String Kod="11-500" ;
        private String City="gizycko";


public Person(){}

	public Person(String Name, String Link){
		this.Name = Name;
		this.Link = Link;
	}

	public Person(int id, String Name, String Link){
		this.Id = id;
		this.Name = Name;
		this.Link = Link;
	}

	public Person(int id, String Name, String Link, String Kod, String City){
		this.Id = id;
		this.Name = Name;
		this.Link = Link;
		this.City = City;
                this.Kod = Kod;
	}
        
        public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
        
        
        public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
        
        
        public String getLink() {
		return Link;
	}
	public void setLink(String Link) {
		this.Link = Link;
	}
        
        
        public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;
	}
        
        
        public String getKod() {
		return Kod;
	}
	public void setKod(String Kod) {
		this.Kod = Kod;
	}
        
         
        
        
}