public class Sheep extends Mammal {
	private static int count = 0;

	public Sheep(String name, int age) {
		super(name, age);
		setLegNumber(4);
		setNumberOfOffsprings(1);
		setPregnancyPerYear(1);
		count++;
	}
	//Returns greeting
	public void sayGreeting() {
		System.out.println("Four legs good, two legs better!");
	}
	//Returns count
	public static int getCount() {
		return count;
	}
	//Decrements count
	public static void decrementCount() {
		count--;
	}
}

