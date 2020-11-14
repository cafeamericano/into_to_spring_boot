package com.matthew.myproject.model;

// Class Declaration
public class Dog
{
	// Instance Variables
	int id;
	String name;
	String breed;
	int age;
	String color;

	// Constructor Declaration of Class
	public Dog(int id, String name, String breed, int age, String color)
	{
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.color = color;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// method 0
	public String getId()
	{
		return Integer.toString(id);
	}

	// method 1
	public String getName()
	{
		return name;
	}

	// method 2
	public String getBreed()
	{
		return breed;
	}

	// method 3
	public int getAge()
	{
		return age;
	}

	// method 4
	public String getColor()
	{
		return color;
	}

	@Override
	public String toString()
	{
		return("Hi my name is "+ this.getName()+
			".\nMy breed,age and color are " +
			this.getBreed()+"," + this.getAge()+
			","+ this.getColor());
	}

	// public static void main(String[] args)
	// {
	// 	Dog tuffy = new Dog("tuffy","papillon", 5, "white");
	// 	System.out.println(tuffy.toString());
	// }
}
