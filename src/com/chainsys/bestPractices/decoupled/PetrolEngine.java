package com.chainsys.bestPractices.decoupled;

public class PetrolEngine implements Iengine {
	public void start() {
		System.out.println("petrol Engine Started");
	}
	public void stop() {
		System.out.println("petrol Engine Stopped");
	}

}
