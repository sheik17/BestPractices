package com.chainsys.bestPractices.coupled;

public class TestCar {

	public static void main(String[] args) {
		Car car=new Car();
		car.startCar();
//		PetrolEngine pe=new PetrolEngine();
//		pe.start();
//		 pe=null;
		SteelWheel[] carWheels=car.getWheels();
		int length=carWheels.length;
		for(int i=0;i<length;i++)
		{
			System.out.println(carWheels[i].location);
		}
		
	}

}
