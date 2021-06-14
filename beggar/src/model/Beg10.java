package model;

public class Beg10 implements Runnable {
	
	
	int sec, min;
	int day=1;
	
	
	@Override
	public void run() {
		 int n=0;

         while(true){
         	n++;
         	sec  = n % 60;
             min  = n / 60 % 60;
             
             if(min==0) { //min==0
             	//낮. 구걸을 할 수 있음
            	 System.out.println("낮");
             }
             if(min==1) { //min==1
             	System.out.println("밤이 되었습니다. 구걸을 할 수 없습니다.");
             }
             if(min==2) {
             	n=0;
             	day++;
             	System.out.println(day + "일째");
             }
 			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
         }
		
	}

		
	}
	

