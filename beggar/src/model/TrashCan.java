package model;


public class TrashCan {
	
	public int trashCan() {

		int[] arr = {1, 2, 3, 3, 3, 3, 3, 3, 3, 3};
		
        double random= Math.floor(Math.random()*(arr.length-1));
        
        return arr[(int)random];
	
	}
	
}
