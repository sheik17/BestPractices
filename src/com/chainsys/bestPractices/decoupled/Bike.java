package com.chainsys.bestPractices.decoupled;

//object of this class can work with any engine, and with any Wheel
//The car class is decoupled from PetrolEngine class, and SteelWheel class
public class Bike {
	private Iengine engine;// early bound with engine interface
	private Iwheel[] wheels;// early bound with wheel interface

	public Iengine getEngine() {
		return engine;
	}

	// The type of engine will be injected to the bike class
	// At runtime using the setter method. This is called as setter based
	// dependency injection
	public void setEngine(Iengine engine) {
		this.engine = engine;
	}

	// The type of wheel will be injected to the bike class
	// At runtime using the setter method. This is called as setter based
	// dependency injection
	public void setWheels(Iwheel[] wheels) {
		this.wheels = wheels;
	}

//	public Bike(Iengine engine,Iwheel[] wheel) {
//		this.engine = engine;
//		this.Wheels = wheel;
//	}

	public void startBike() {
		engine.start();
		wheels[0].rotate();
		wheels[1].rotate();
	}

	public Iwheel[] getWheels() {
		return this.wheels;
	}
}
