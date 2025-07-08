package utilities;

import java.util.Random;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class FakerUtility {
	public static int getRandomNumber() {  //mistake
		Random rand=new Random();
		int randomNumber=rand.nextInt(100000);
		return randomNumber;
	}
	public static String getFakerFirstName() {
		Faker fakers= new Faker();
		Address address= fakers.address();
		String firstName= address.firstName();
		return firstName;
	}
	public static String getFakerLastName() {
		Faker fakers= new Faker();
		Address address= fakers.address();
		String lastName= address.lastName();
		return lastName;
		
	}
	
	public static String getFakerAddress() {
		Faker fakers= new Faker();
		Address address= fakers.address();
		String address1= address.fullAddress();
		return address1;
	}
	public static String getFakerCountry() {
		Faker fakers= new Faker();
		Address address= fakers.address();
		String country= address.country();
		return country;
	}
	public static String getFakerCityName() {
		Faker fakers= new Faker();
		Address address= fakers.address();
		String cityName= address.cityName();
		return cityName;
	}
	public static String getFakerZipCode() {
		Faker fakers= new Faker();
		Address address= fakers.address();
		String zipcode= address.zipCode();
		return zipcode;
	}
	public static String getFakerTitle() {
		Faker fakers= new Faker();
		Address address= fakers.address();
		String title= address.firstName();
		return title;
	}

	
	

}
