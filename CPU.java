package edu.iit.cc;

import java.io.IOException;

/**
 * Author : Priya
 * 
 * creates threads and object of CPUTask depending on user Input.
 * */
public class CPU {
	
	public static String type;
	private static  long iops = 0;
	private static long flops = (long) 0.0;
		public static void main(String args[]) throws IOException, InterruptedException{
			
			/* depending on the user inputs the threads are created and
			 *  the class CPUTask is executed inside the Thread.*/
			
				type = args[1];
				if(args[0].equalsIgnoreCase("1")){
					 CPUTask.start = System.currentTimeMillis();
					    Thread t = new Thread(new CPUTask(),"T");
						t.start();		 
						
				}
				else if(args[0].equalsIgnoreCase("2")){
					 CPUTask.start = System.currentTimeMillis();
					 Thread t11 = new Thread(new CPUTask());
					 Thread t2 = new Thread(new CPUTask() , "T");
					 t11.start();
					 t11.join();
					 t2.start(); 
					 
				}
				else if(args[0].equalsIgnoreCase("4")){
					 CPUTask.start = System.currentTimeMillis();
					Thread th1 = new Thread(new CPUTask());
					 Thread th2 = new Thread(new CPUTask());
					 Thread th4 = new Thread(new CPUTask());
					 Thread th3 = new Thread(new CPUTask(), "T");
					 th1.start();
					 th1.join();
					 th2.start();
					 th2.join();
					 th4.start();
					 th4.join();
					 th3.start();
				}
				else 
				 System.out.println("Wrong choice");
				
				
		}
	
}
