package com.chainsys.bestPractices.decoupled;

//object of this class can work with any engine, and with any Wheel
//The car class is decoupled from PetrolEngine class, and SteelWheel class
public class Car {
	private Iengine engine;// early bound with engine interface
	private Iwheel[] Wheels;// early bound with wheel interface
	// The type of engine, and the type of wheel will be injected to the car class
	//At runtime using the constructors. This is called as constructor based
	//dependency injection
	public Car(Iengine engine,Iwheel[] wheel) {
		this.engine = engine;
		this.Wheels = wheel;
	}

	public void startCar() {
		engine.start();
		Wheels[0].rotate();
		Wheels[1].rotate();
		Wheels[2].rotate();
		Wheels[3].rotate();
	}

	public Iwheel[] getWheels() {
		return this.Wheels;
	}
}
