public class Automobile {
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;

    public Automobile() {
    	//default constructor
    	make = "";
    	model = "";
    	color = "";
    	year = 0;
    	mileage = 0;
    }
	
	public Automobile(String make, String model, String color, int year, int mileage) {
		//parameterized constructor
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.mileage = mileage;
	}

    
	public String getMake() { //get make
		return make;
      }

	
	public void setMake(String make) { //set make
		this.make = make;
      }

	
	public String getModel() { //get model
		return model;
      }

	
     public void setModel(String model) { //set model
    	 this.model = model;
      }

     
     public String getColor() { //get color
    	 return color;
      }

     
     public void setColor(String color) { //set color
    	 this.color = color;
      }

     
     public int getYear() { //get year
    	  return year;
      }

     
     public void setYear(int year) { //set year
    	 this.year = year;
      }

     
     public int getMileage() { //get mileage
    	 return mileage;
      }	

     
     public void setMileage(int mileage) { //set mileage
    	 this.mileage = mileage;
      }


      public String toCSV() { //for save to file
    	  return getMake() + ", " + getModel() + ", " + getColor() + ", " + getYear() + ", " + getMileage();
      }

      
      public String toString() { //for save to file
            return "Make: " + make + "\nModel: " + model + "\nColor: " + color + "\nYear: " + year + "\nMileage: " + mileage;
      }
}