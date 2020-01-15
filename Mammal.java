public class Mammal extends Animal {

	public Mammal(String name, int age) {
		super(name, age);
	}

	public void walk() {
		System.out.println("My name is " + super.getName() + " and I can walk to the far away lands!");
	}

	@Override
	public void reproduce() {
		System.out.println("My name is " + super.getName() + " and I give birth!");
	}

	public void herbivore() {
		System.out.println("My name is " + super.getName() +" and I eat plants only!");
	}

}
