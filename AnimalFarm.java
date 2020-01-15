import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
//Sorting by name
class AnimalComparatorByName implements Comparator<Animal> {
	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
	}
}
//Sorting by leg number
class AnimalComparatorByLegNumber implements Comparator<Animal> {
	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.getLegNumber() - o2.getLegNumber();
	}
}
//Sorting by age
class AnimalComparatorByAge implements Comparator<Animal> {
	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.getAge() - o2.getAge();
	}
}

public class AnimalFarm {
	private ArrayList<Animal> animalList;
	private ArrayList<String> animalNames;
	private int CAPACITY;
	private static int numberOfAnimals = 0;
	//Creating constructor
	public AnimalFarm(int capacity) {
		this.CAPACITY = capacity;
		this.animalList = new ArrayList<Animal>();
		this.animalNames = new ArrayList<String>();
	}
	//Returns number of animals
	public int getNumberOfAnimals() {
		return numberOfAnimals;
	}
	//Returns animal list
	public ArrayList<Animal> getAnimalList() {
		return this.animalList;
	}
	//Adds animal to animal list and animal farm if there is enough capacity and no same name
	public boolean addAnimal(Animal animal) throws IllegalNameException {
		String animalName = animal.getName();
		if (this.animalNames.contains(animalName)) {
			throw new IllegalNameException("Animal farm already contains " + animalName);
		}
		if ((numberOfAnimals + 1) <= this.CAPACITY) {
			this.animalList.add(animal);
			this.animalNames.add(animalName);
			numberOfAnimals++;
			return true;
		}
		return false;
	}
	//Removes animal
	public boolean removeAnimal(String name) {
		int ind = this.animalNames.indexOf(name);
		if (ind == -1) {
			return false;
		}
		Animal animal = this.animalList.get(ind);
		this.animalList.remove(ind);
		this.animalNames.remove(ind);
		if (animal instanceof Chicken) {
			Chicken.decrementCount();
		} else if (animal instanceof Donkey) {
			Donkey.decrementCount();
		} else if (animal instanceof Horse) {
			Horse.decrementCount();
		} else if (animal instanceof Pig) {
			Pig.decrementCount();
		} else if (animal instanceof Raven) {
			Raven.decrementCount();
		} else if (animal instanceof Sheep) {
			Sheep.decrementCount();
		}
		animal = null;
		return true;
	}
	//Prints greetings of all animals
	public void printAllAnimalGreetings() {
		int size = this.animalList.size();
		for (int i = 0; i < size; i++) {
			printOneAnimalGreeting(this.animalList.get(i));
		}
	}
	//Prints greeting of an animal
	public void printOneAnimalGreeting(Animal animal) {
		animal.sayGreeting();
	}
	//Prints all animal names 
	public void printAllAnimalNames() {
		int size = this.animalList.size();
		for (int i = 0; i < size; i++) {
			printOneAnimalName(this.animalList.get(i));
		}
	}
	//Prints one animal name
	public void printOneAnimalName(Animal animal) {
		System.out.println(animal.getName());
	}
	//Prints all animals toString's
	public void printAllAnimals() {
		int size = this.animalList.size();
		for (int i = 0; i < size; i++) {
			System.out.println(this.animalList.get(i).toString());
		}
	}
	//Calculates next year population forecast
	public int nextYearPopulationForecast() {
		int forecast = numberOfAnimals;
		int size = this.animalList.size();
		for (int i = 0; i < size; i++) {
			Animal animal = this.animalList.get(i);
			forecast += animal.getNumberOfOffsprings() * animal.getPregnancyPerYear();
		}
		return forecast;
	}
	//Prints animal movements
	public void AnimalMovements() {
		int size = this.animalList.size();
		for (int i = 0; i < size; i++) {
			Animal animal = this.animalList.get(i);
			if (animal instanceof Bird) {
				((Bird) animal).fly();
			} else if (animal instanceof Mammal) {
				((Mammal) animal).walk();
			}
		}
	}
	//Prints eating habits
	public void eatingHabits() {
		int size = this.animalList.size();
		for (int i = 0; i < size; i++) {
			Animal animal = this.animalList.get(i);
			if (animal instanceof Bird) {
				((Bird) animal).omnivore();
			} else if (animal instanceof Mammal) {
				((Mammal) animal).herbivore();
			}
		}
	}
	//Prints sorted version of animals by name
	public void sortAlphabetically() {
		ArrayList<Animal> copyList = new ArrayList<Animal>(animalList);
		AnimalComparatorByName c = new AnimalComparatorByName();
		copyList.sort(c);
		int size = copyList.size();
		for (int i = 0; i < size; i++) {
			Animal animal = copyList.get(i);
			System.out.println(animal.getName());
		}
	}
	//Prints sorted version of animals by leg number
	public void sortBasedOnLegNumber() {
		ArrayList<Animal> copyList = new ArrayList<Animal>(animalList);
		AnimalComparatorByLegNumber c = new AnimalComparatorByLegNumber();
		copyList.sort(c);
		int size = copyList.size();
		for (int i = 0; i < size; i++) {
			Animal animal = copyList.get(i);
			System.out.println(animal.getName() + " has " + animal.getLegNumber() + " legs!");
		}
	}
	//Prints sorted version of animals by age
	public void sortBasedOnAge() {
		ArrayList<Animal> copyList = new ArrayList<Animal>(animalList);
		AnimalComparatorByAge c = new AnimalComparatorByAge();
		copyList.sort(c);
		int size = copyList.size();
		for (int i = 0; i < size; i++) {
			Animal animal = copyList.get(i);
			System.out.println(animal.getName() + " is " + animal.getAge() + " years old!");
		}
	}
	//Searches based on name
	public void searchBasedOnName(String name) {
		int size = this.animalList.size();
		for (int i = 0; i < size; i++) {
			Animal animal = this.animalList.get(i);
			if (animal.getName().equals(name)) {
				System.out.println(animal.toString());
				break;
			}
		}
	}
	//Searches based on age
	public void searchBasedOnAge(int age) {
		int size = this.animalList.size();
		for (int i = 0; i < size; i++) {
			Animal animal = this.animalList.get(i);
			if (animal.getAge() == age) {
				System.out.println(animal.toString());
			}
		}
	}
	//Creates a file and prints report to the file
	public void printReport(String filename) throws FileNotFoundException {
		PrintWriter a = new PrintWriter(filename);
		a.print("We have a total of " + numberOfAnimals + " animals in the farm.");
		int chickenCount = Chicken.getCount();
		int donkeyCount = Donkey.getCount();
		int horseCount = Horse.getCount();
		int pigCount = Pig.getCount();
		int ravenCount = Raven.getCount();
		int sheepCount = Sheep.getCount();
		if (chickenCount > 0) {
			a.print("\n\n\t" + chickenCount + " of them are Chicken. Those are:" + "\n\t\tName\tAge\tLeg Number");
			for(int j = 0; j < chickenCount; j++){
				int size = this.animalList.size();
				for (int i = 0; i < size; i++) {
					Animal animal = this.animalList.get(i);
					if (animal instanceof Chicken) {
						a.print("\n\t\t" + ((Chicken) animal).getName() + "\t" + ((Chicken) animal).getAge() + "\t"
								+ ((Chicken) animal).getLegNumber());
					}
				}
			}

		}
		if (donkeyCount > 0) {
			a.print("\n\n\t" + donkeyCount + " of them are Donkey. Those are:" + "\n\t\tName\tAge\tLeg Number");
			for(int j = 0; j < donkeyCount; j++){
				int size = this.animalList.size();
				for (int i = 0; i < size; i++) {
					Animal animal = this.animalList.get(i);
					if (animal instanceof Donkey) {
						a.print("\n\t\t" + ((Donkey) animal).getName() + "\t" + ((Donkey) animal).getAge() + "\t"
								+ ((Donkey) animal).getLegNumber());
					}
				}
			}

		}
		if (horseCount > 0) {
			a.print("\n\n\t" + horseCount + " of them are Horse. Those are:" + "\n\t\tName\tAge\tLeg Number");
			for(int j = 0; j < horseCount; j++){
				int size = this.animalList.size();
				for (int i = 0; i < size; i++) {
					Animal animal = this.animalList.get(i);
					if (animal instanceof Horse) {
						a.print("\n\t\t" + ((Horse) animal).getName() + "\t" + ((Horse) animal).getAge() + "\t"
								+ ((Horse) animal).getLegNumber());
					}
				}
			}

		}
		if (pigCount > 0) {
			a.print("\n\n\t" + pigCount + " of them are Pig. Those are:" + "\n\t\tName\tAge\tLeg Number");
			for(int j = 0; j < pigCount; j++){
				int size = this.animalList.size();
				for (int i = 0; i < size; i++) {
					Animal animal = this.animalList.get(i);
					if (animal instanceof Pig) {
						a.print("\n\t\t" + ((Pig) animal).getName() + "\t" + ((Pig) animal).getAge() + "\t"
								+ ((Pig) animal).getLegNumber());
					}
				}
			}

		}
		if (ravenCount > 0) {
			a.print("\n\n\t" + ravenCount + " of them are Raven. Those are:" + "\n\t\tName\tAge\tLeg Number");
			for(int j = 0; j < ravenCount; j++){
				int size = this.animalList.size();
				for (int i = 0; i < size; i++) {
					Animal animal = this.animalList.get(i);
					if (animal instanceof Raven) {
						a.print("\n\t\t" + ((Raven) animal).getName() + "\t" + ((Raven) animal).getAge() + "\t"
								+ ((Raven) animal).getLegNumber());
					}
				}
			}

		}
		if (sheepCount > 0) {
			a.print("\n\n\t" + sheepCount + " of them are Sheep. Those are:" + "\n\t\tName\tAge\tLeg Number");
			for(int j = 0; j < sheepCount; j++){
				int size = this.animalList.size();
				for (int i = 0; i < size; i++) {
					Animal animal = this.animalList.get(i);
					if (animal instanceof Sheep) {
						a.print("\n\t\t" + ((Sheep) animal).getName() + "\t" + ((Sheep) animal).getAge() + "\t"
								+ ((Sheep) animal).getLegNumber());
					}
				}
			}

		}
		a.close();
	}
}
