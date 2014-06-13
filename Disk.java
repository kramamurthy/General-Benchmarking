package edu.iit.cc;

import java.io.IOException;

public class Disk {

	public static void main(String args[]) throws InterruptedException, IOException{
		//instruction will be 1B read 1 2 "1B read 1"
		System.out.println("Disk Benchmark");
		DiskTask diskTask = new DiskTask();
		diskTask.setBlockSize(args[0]);
		diskTask.setOperation(args[1]);
		diskTask.setOptType(Integer.parseInt(args[2]));
		
		Thread th1 = new Thread(new ReadWriteFile(diskTask),"ReadWriteFile1");
		th1.start();
		
		
		if(Integer.parseInt(args[3]) == 2){
			DiskTask diskTask2 = new DiskTask();
			diskTask2.setBlockSize(args[0]);
			diskTask2.setOperation(args[1]);
			diskTask2.setOptType(Integer.parseInt(args[2]));
			Thread th2 = new Thread(new ReadWriteFile(diskTask2),"ReadWriteFile2");
			th1.join();
			th2.start();
		}
		
			
		
		
	}
}
