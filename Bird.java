public class Bird extends Animal {
	public Bird(String name, int age) {
		super(name, age);
	}

	public void fly() {
		System.out.println("My name is " + super.getName() + " and I can fly to the endless skies!");
	}

	@Override
	public void reproduce() {
		System.out.println("My name is " + super.getName() + " and I lay eggs!");
	}

	public void omnivore() {
		System.out.println("My name is " + super.getName() + " and I can eat everything!");
	}

}
