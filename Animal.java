public class Animal {

	private String name;
	private int legNumber;
	private int age;
	private int pregnancyPerYear;
	private int numberOfOffsprings;
	//Creating constructor
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//Prints greeting
	public void sayGreeting() {
		System.out.println("Have nothing to say!");
	}
	//Prints reproduce method
	public void reproduce() {
		System.out.println("None of your business!!");
	}
	//Overriding toString method
	@Override
	public String toString() {
		return "My name is " + this.name + "!\n" + "I am " + this.age + " years old!\n" + "I have " + this.legNumber + " legs!";
	}
	//Returns name
	public String getName() {
		return this.name;
	}
	//Returns leg number
	public int getLegNumber() {
		return this.legNumber;
	}
	//Returns age
	public int getAge() {
		return this.age;
	}
	//Returns pregnancy per year
	public int getPregnancyPerYear() {
		return this.pregnancyPerYear;
	}
	//Returns number off of springs
	public int getNumberOfOffsprings() {
		return this.numberOfOffsprings;
	}
	//Sets name
	public void setName(String name) {
		this.name = name;
	}
	//Sets leg number
	public void setLegNumber(int legNumber) {
		this.legNumber = legNumber;
	}
	//Sets age
	public void setAge(int age) {
		this.age = age;
	}
	//Sets pregnancy per year
	public void setPregnancyPerYear(int pregnancyPerYear) {
		this.pregnancyPerYear = pregnancyPerYear;
	}
	//Sets number of offsprings
	public void setNumberOfOffsprings(int numberOfOffsprings) {
		this.numberOfOffsprings = numberOfOffsprings;
	}

}































