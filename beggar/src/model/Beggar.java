package model;

public class Beggar {
	
	private int num;
	private String name;
	private int money;
	private int hunger;
	private int tiredness;
	public int level;
	private int fight;
	private int thief;
	
	
	public Beggar() {}


	public Beggar(int num, String name, int money, int hunger, int tiredness, int level, int fight, int thief) {
		super();
		this.num = num;
		this.name = name;
		this.money = money;
		this.hunger = hunger;
		this.tiredness = tiredness;
		this.level = level;
		this.fight = fight;
		this.thief = thief;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public int getHunger() {
		return hunger;
	}


	public void setHunger(int hunger) {
		this.hunger = hunger;
	}


	public int getTiredness() {
		return tiredness;
	}


	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getFight() {
		return fight;
	}


	public void setFight(int fight) {
		this.fight = fight;
	}


	public int getThief() {
		return thief;
	}


	public void setThief(int thief) {
		this.thief = thief;
	}



	
	
	

	
	
	
}
