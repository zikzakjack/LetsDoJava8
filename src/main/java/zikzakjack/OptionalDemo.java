package zikzakjack;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		Person person = new Person();
		try {
		System.out.println("InsuranceName : " + person.getCar().getInsurance().getName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/*************************************************************
		 * Create empty Optional Objects from static factory method
		 *************************************************************/
		PersonOpt personOpt = new PersonOpt();
		personOpt.setCarOpt(Optional.empty());
		System.out.println("\n* Create empty Optional Objects from static factory method");
		System.out.println("CarOpt : " + personOpt.getCarOpt());
		System.out.println("CarOpt : " + personOpt.getCarOpt().isPresent());

		/*************************************************************
		 * Create Optional Objects from a non null value
		 *************************************************************/
		PersonOpt personOpt1 = new PersonOpt();
		personOpt1.setCarOpt(Optional.of(new CarOpt()));
		System.out.println("\n* Create Optional Objects from a non null value");
		System.out.println("CarOpt : " + personOpt1.getCarOpt());
		System.out.println("CarOpt : " + personOpt1.getCarOpt().isPresent());

		/*************************************************************
		 * Create Optional Objects from a null value
		 *************************************************************/
		PersonOpt personOpt2 = new PersonOpt();
		CarOpt carOpt = null;
		personOpt2.setCarOpt(Optional.ofNullable(carOpt));
		System.out.println("\n* Create Optional Objects from a null value");
		System.out.println("CarOpt : " + personOpt2.getCarOpt());
		System.out.println("CarOpt : " + personOpt2.getCarOpt().isPresent());

		/*************************************************************
		 * Extracting value from Optionals
		 *************************************************************/
		PersonOpt person3 = new PersonOpt();
		CarOpt car3 = new CarOpt();
		InsuranceOpt insurance3 = new InsuranceOpt();

		Optional<InsuranceOpt> insuranceOpt3 = Optional.of(insurance3);
		Optional<CarOpt> carOpt3 = Optional.of(car3);
		
		car3.setInsuranceOpt(insuranceOpt3);
		person3.setCarOpt(carOpt3);
		
		System.out.println("\n* Extracting value from Optionals");
		System.out.println(insuranceOpt3.map(InsuranceOpt::getNameOpt));
		insurance3.setNameOpt(null);
		System.out.println(insuranceOpt3.map(InsuranceOpt::getNameOpt));
	}

}

class Person {
	Car car;
	public Car getCar() {return car;}
	public void setCar(Car car) {this.car = car;}
}

class Car {
	Insurance insurance;
	public Insurance getInsurance() {return insurance;}
	public void setInsurance(Insurance insurance) {this.insurance = insurance;}
}

class Insurance {
	String name = "itsgotaname";
	public String getName() {return name;}
}

class PersonOpt {
	Optional<CarOpt> carOpt;
	public Optional<CarOpt> getCarOpt() {return carOpt;}
	public void setCarOpt(Optional<CarOpt> carOpt) {this.carOpt = carOpt;}
	
}

class CarOpt {
	Optional<InsuranceOpt> insuranceOpt = Optional.of(new InsuranceOpt());
	public Optional<InsuranceOpt> getInsuranceOpt() {return insuranceOpt;}
	public void setInsuranceOpt(Optional<InsuranceOpt> insuranceOpt) {this.insuranceOpt = insuranceOpt;}
}

class InsuranceOpt {
	String nameOpt = "itsgotaname";
	public String getNameOpt() {return nameOpt;}
	public void setNameOpt(String nameOpt) {this.nameOpt = nameOpt;}
}