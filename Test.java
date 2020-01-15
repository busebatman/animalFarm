import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	//Buse BATMAN - 150117011
	public static void main(String[] args) throws FileNotFoundException, IllegalNameException {
		Scanner input = new Scanner(System.in);
		System.out.print(
				"Welcome to Animal Farm simulation program!\n" + "Please enter the capacity of the animal farm: ");
		int capacity = input.nextInt();
		AnimalFarm animalFarm = new AnimalFarm(capacity);
		boolean a = true;
		while(a){
		System.out.print("0 - Exit the program\n" + "1 - Add animal\n" + "2 - Remove animal\n" + "3 - Search animal\n"
				+ "4 - Sort animal\n" + "5 - Calculate next year's populations estimate\n"
				+ "6 - Print all animal's movements\n" + "7 - Print all animal's eating habits\n" + "8 - Print report\n"
				+ "Please enter your choice:");
		int option = input.nextInt();
		if(option==0){
			a=false;
		}
		switch (option) {
		case 1:
			System.out.print("1 - Chicken \n" + "2 - Donkey\n" + "3 - Horse\n" + "4 - Pig\n" + "5 - Raven\n"
					+ "6 - Sheep\n" + "Select animal type:");
			int type = input.nextInt();
			System.out.print("Enter the name:");
			String name = input.next();
			System.out.print("Enter the age:");
			int age = input.nextInt();
			if(type==1){
				Chicken chicken = new Chicken(name,age);
				animalFarm.addAnimal(chicken);
			}
			else if(type==2){
				Donkey donkey = new Donkey(name,age);
				animalFarm.addAnimal(donkey);
			}
			else if(type==3){
				Horse horse = new Horse(name,age);
				animalFarm.addAnimal(horse);
			}
			else if(type==4){
				Pig pig = new Pig(name,age);
				animalFarm.addAnimal(pig);
			}
			else if(type==5){
				Raven raven = new Raven(name,age);
				animalFarm.addAnimal(raven);
			}
			else if(type==6){
				Sheep sheep = new Sheep(name,age);
				animalFarm.addAnimal(sheep);
			}
		
		break;
			
		case 2:
			System.out.print("\nEnter the name:");
			name = input.next();
			animalFarm.removeAnimal(name);
			break;
		case 3:
			System.out.println("1 - Search based on name\n" + "2 - Search based on age");
			option = input.nextInt();
			if (option == 1) {
				System.out.print("Enter name:");
				name = input.next();
				animalFarm.searchBasedOnName(name);
			} else {
				System.out.print("Enter age:");
				age = input.nextInt();
				animalFarm.searchBasedOnAge(age);
			}
			break;
		case 4:
			System.out.println("1 - Sort based on name\n" + "2 - Sort based on leg number\n" + "3 - Sort based on age\n" + "4 - Sort based on additon date" );
			option = input.nextInt();
			if(option == 1){
				animalFarm.sortAlphabetically();
			}
			else if(option == 2){
				animalFarm.sortBasedOnLegNumber();
			}
			else if(option == 3){
				animalFarm.sortBasedOnAge();
			}
			else{
				int size = animalFarm.getAnimalList().size();
				for (int i = 0; i < size; i++) {
					System.out.println(animalFarm.getAnimalList().get(i).getName() + " is " + animalFarm.getAnimalList().get(i).getAge() + " years old.");
				}
			}
			break;
		case 5:
			System.out.println(animalFarm.nextYearPopulationForecast());
			break;
		case 6:
			animalFarm.AnimalMovements();
			break;
		case 7:
			animalFarm.eatingHabits();
			break;
		case 8:
			System.out.println("Enter filename");
			String filename = input.next();
			animalFarm.printReport(filename);
			break;
		}
		
	}
		input.close();
	}

}

