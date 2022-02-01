import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleInventory {
	//object list
	static ArrayList<Automobile> vehicleList = new ArrayList<Automobile>();

  	public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        do {
              // display menu
              menu();
              int i = scan.nextInt(); //int for case selection
              scan.nextLine(); //input
              switch (i) {
              case 1:
            	  	//add vehicle method
                    addVehicle();
                    break;
              case 2:
            	  	//remove vehicle method
                    removeVehicle();
                    break;
              case 3:
            	  	//update vehicle method
                    updateVehicle();
                    break;
              case 4:
                    // display vehicles method
                    displayVehicles();
                    break;
              case 5:
            	  	//print to file
            	  	saveToFile("inventory.txt");
            	  	break;  	
              case 6:
            	  	//exit program
                    System.out.println("Exiting...");
                    break;
              default:
            	  	//invalid choice if out of range 1-6
                    System.out.println("Invalid choice.");
              }
              if (i == 6)
                    break;
              System.out.println();
        } while (true);
  	}
  	
  	
  	
  	public static void menu() {
  		//display menu
  		System.out.println("---------MENU---------");
        System.out.println("1. Add New Vehicle"); //case 1, add new vehicle method
        System.out.println("2. Remove Vehicle"); //case 2, remove vehicle method
        System.out.println("3. Update Vehicle"); //case 3, update vehicle method
        System.out.println("4. Display All Vehicles"); //case 4, display vehicles method
        System.out.println("5. Save To File:"); //case 5, save to file method
        System.out.println("6. Exit"); //exit program case 6
        System.out.println("Enter number followed by enter key: ");
  	}

      
	public static void addVehicle() {
		//ADD VEHICLE to list
		Scanner scan = new Scanner(System.in); //needed for input
		System.out.print("Enter the make of automobile: ");
		String make = scan.nextLine(); //input = make
		System.out.print("Enter the model of automobile: ");
		String model = scan.nextLine(); //input = model
		System.out.print("Enter the color of automobile: ");
		String color = scan.nextLine(); //input = color
		System.out.print("Enter the year of automobile: ");
		int year = scan.nextInt(); //input = year
		System.out.print("Enter the mileage of automobile: ");
		int mileage = scan.nextInt(); //input = mileage
		Automobile a = new Automobile(make, model, color, year, mileage); //values stored as array
		vehicleList.add(a); //add to vehicle list
		System.out.println("Vehicle added"); //output for confirmation to user
	}

      
	public static void removeVehicle() {
		//REMOVE VEHICLE from list
		Scanner scan = new Scanner(System.in);
		//get make and model to update info
		System.out.print("Enter the make of automobile to be removed: ");
		String make = scan.nextLine(); //get make to compare
		System.out.print("Enter the model of automobile to be removed: ");
		String model = scan.nextLine(); //get model to compare
		boolean found = false;
		int index = 0;
		//for loop to check array for make/model acquired from input
		try {
		for (int i = 0; i < vehicleList.size(); i++) {
			Automobile a1 = vehicleList.get(i);
			if (a1.getMake().equalsIgnoreCase(make) && a1.getModel().equalsIgnoreCase(model)) {
				found = true;
				//current index
				index = i;
				break;
			}
		}
			if (found) {
            	//remove vehicle if found
				vehicleList.remove(index);
                System.out.println("Vehicle successfully removed");
            } else {
            	System.out.println("Make/model entered not found");
            }
		} catch (Exception e) {
			System.out.println("Failure. " + e);
		}
	}
	
	
  	public static void updateVehicle() {
  		//UPDATE VEHICLES in list
  		Scanner scan = new Scanner(System.in);
  		System.out.print("Enter the current make of Automobile to be updated: ");
        String make = scan.nextLine(); //input = make to search array
        System.out.print("Enter the current model of Automobile to be updated: ");
        String model = scan.nextLine(); //input = model to search array
        boolean found = false;
        try {
        for (int i = 0; i < vehicleList.size(); i++) {
        	//search array for make/model
              Automobile a1 = vehicleList.get(i);
              if (a1.getMake().equalsIgnoreCase(make) && a1.getModel().equalsIgnoreCase(model)) {
                    System.out.println("Vehicle found");
                    System.out.println("Enter the new make of Automobile: ");
                    make = scan.nextLine(); //input = make
                    System.out.println("Enter the new model of Automobile: ");
                    model = scan.nextLine(); //input = model
                    System.out.println("Enter the new color of Automobile: ");
                    String color = scan.nextLine(); //input = color
                    System.out.println("Enter the new year of Automobile: ");
                    int year = scan.nextInt(); //input = year
                    System.out.println("Enter the new mileage of Automobile: ");
                    int mileage = scan.nextInt(); //input = mileage
                    a1.setMake(make); //set make
                    a1.setModel(model); //set model
                    a1.setColor(color); //set color
                    a1.setYear(year); //set year
                    a1.setMileage(mileage); //set mileage
                    found = true;
                    break;
              }
        }
        	if (found) {
        		System.out.println("Vehicle updated successfully.");
        	} else {
        		System.out.println("Specified vehicle not found.");
        	}
        } catch (Exception e) {
        	System.out.println("Failure. " + e);
        }
  }

      
      	public static void displayVehicles() {
      		// DISPLAY VEHICLES in list
      		System.out.println("Vehicle List:");
      			for (Automobile a : vehicleList) {
      				//iterate through array to print make/model/year/color/mileage of each vehicle stored
      				System.out.println(a + "\n");
            	}
      	}

      	
      	public static void saveToFile(String filename) throws FileNotFoundException {
      		//SAVE LIST TO FILE
      		String inpt;
            Scanner scan = new Scanner(System.in);
      		PrintWriter pw = new PrintWriter(filename);
            String text = "Make,Model,Color,Year,Mileage\n";
            try {
            System.out.println("Would you like to save to file? Y/N");
            inpt = scan.nextLine();
            if (inpt.equals("Y")) {
	            for (Automobile a : vehicleList) {
	                  text += a.toCSV() + "\n";
	            }
	            pw.write(text);
	            pw.flush();
	            pw.close();
	            System.out.println("Following vehicle details have been written to " + filename + " file");
	            System.out.println();
	            System.out.println(text);
            } else if (inpt.equals("N")) {
            	System.out.println("File will not be printed.");
            }
            } catch (NullPointerException e) {
            	System.out.println("Failure. Null pointer exception");
            }
      	}
}