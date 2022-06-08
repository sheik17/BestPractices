package com.chainsys.bestPractices.coupled;

//object of this class can work petrol engine and steel Wheel
public class Car {
	private PetrolEngine engine;// early bound with petrol engine
	private SteelWheel[] Wheels;// early bound with steel wheel

	public Car() {
		engine = new PetrolEngine();
		Wheels = new SteelWheel[4];
		Wheels[0] = new SteelWheel();
		Wheels[0].location = "front left";
		Wheels[1] = new SteelWheel();
		Wheels[1].location = "front right";
		Wheels[2] = new SteelWheel();
		Wheels[2].location = "back left";
		Wheels[3] = new SteelWheel();
		Wheels[3].location = "back right";
	}

	public Car(PetrolEngine engine, SteelWheel[] wheel) {
		this.engine = engine;
		this.Wheels = wheel;
		Wheels[0].location = "front left";
		Wheels[1].location = "front right";
		Wheels[2].location = "back left";
		Wheels[3].location = "back right";
	}

	public void startCar() {
		engine.start();
		Wheels[0].rotate();
		Wheels[1].rotate();
		Wheels[2].rotate();
		Wheels[3].rotate();
	}

	public SteelWheel[] getWheels() {
		return this.Wheels;
	}
}
