package edu.iit.cc;

/**
 * Author : Priya 
 * 
 * A Runnable class, CalculateFLOPS and IOPS depending on the end time.
 * */
public class CPUTask  implements Runnable {

		private int c = 0;
		public static long start ;
		public static long end = 0;
		
		public void calculateIOPS(){
			//iterates between the nested for loop to
			//measure the time taken to execute
			
			for(int i =0;i<1000000;i++){
				for(int j = 0;j<100000;j++){
					c= c+ i*j+(j*10);
				}
			}
			
			 if(Thread.currentThread().getName().equals("T")){
				 CPUTask.end = ( System.currentTimeMillis() - CPUTask.start )/1000 ; //conversion to seconds
				 System.out.println(" End Time : "+end);
				long iops =  1000000000/CPUTask.end;  //No of instruction/ total time taken to execute
				System.out.println("Giga IOPS : "+iops / 1000000000); //conversion to Giga i.e. 10^9
			 }
		}
		public void calculateFLOPS(){
			//iterates between the nested for loop to
			//measure the time taken to execute
			
			for(int i =0;i<1000000;i++){
				for(int j = 0;j<100000;j++){
					c= c+ i*j+(j*10);
				}
			}

			CPUTask.end = ( System.currentTimeMillis() - CPUTask.start )/1000 ;  //conversion to seconds
			 if(Thread.currentThread().getName().equals("T")){ 
				 System.out.println(" End Time : "+end);
					
				 double flops =  1000000000/CPUTask.end;   //No of instruction / total time taken to execute
				System.out.println("Giga FLOPS : "+flops / 1000000000); //conversion to Giga i.e. 10^9
				
			 }
			
		}
		
		public void run(){
			  // requires java 1.5
			System.out.println("Processing started...");
			if(CPU.type.equals("iops")){
					calculateIOPS();
				
			}
			if(CPU.type.equals("flops")){
				calculateFLOPS();
			}
			
				
		}

		
	
}
