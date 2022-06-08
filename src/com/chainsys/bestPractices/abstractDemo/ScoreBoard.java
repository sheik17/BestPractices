package com.chainsys.bestPractices.abstractDemo;

public class ScoreBoard 
{
	public int TargetScore=215;
   private ScoreBoard(){
	   System.out.println("Object created for ScoreBoard");
   }
   public static ScoreBoard createObject() {
	   return new ScoreBoard();
   }
}