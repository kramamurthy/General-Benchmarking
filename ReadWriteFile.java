package edu.iit.cc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Author : Priya
 * 
 * reading and writing operations performed usinf FileInputStream and FileOutputStream.
 * */
public class ReadWriteFile implements Runnable {
	
	public DiskTask dt;
	public FileInputStream fis ;
	public FileOutputStream fos;
	public BufferedReader br ;
	public static long startTime , endTime;
	//public BufferedInputStream bif ;
	public ReadWriteFile(DiskTask diskTask) throws IOException {
			dt = diskTask;
			 fis = new FileInputStream("D://try.txt");
			  br =  new BufferedReader(new InputStreamReader(fis));
	     	fos = new FileOutputStream("D://temp.txt");
			 
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		startTime = System.currentTimeMillis();
		try{
			System.out.println("disk Task  "+dt.getOperation());
		if(dt.getOperation().equalsIgnoreCase("read")){
			System.out.println("Starting to read....");
			ReadFile(dt.getBlockSize() , dt.getOptType()); }
		else if(dt.getOperation().equalsIgnoreCase("write")){
			System.out.println("Starting to write....");
			WriteFile(dt.getBlockSize(), dt.getOptType());}
		endTime = System.currentTimeMillis();
		
		
		double latency = (endTime-startTime);
		System.out.println("Latency :  "+latency);
		double throughput = (dt.getNoOfBytes() *1024*1024) /((latency>0 ? latency : 0)/1000) ; 
		System.out.println("Throughput :  "+throughput/1000);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	private synchronized void WriteFile(String blockSize, int optType) throws IOException {
		String content = "This is the first programming assignment";
			if(optType == 2){ // random
			fis.skip(20);
			}
			System.out.println("writing "+blockSize+" to file..");
			byte[] b  = content.getBytes();
			if(blockSize.equalsIgnoreCase("1B")){			
					dt.setNoOfBytes(1);
				  fos.write(content.getBytes()[0]);
			}
			else if(blockSize.equalsIgnoreCase("1KB")){
				dt.setNoOfBytes(1024);
				 	for(int i=0;i<1024;i++)
					fos.write(content.getBytes()[3]);
				}
			else if(blockSize.equalsIgnoreCase("1MB")){
				dt.setNoOfBytes(1048576);
					for(int i=0;i< 1048576;i++)
						fos.write(content.getBytes()[1]);					
				}
			else if(blockSize.equalsIgnoreCase("1GB")){
				dt.setNoOfBytes(1073741824);
				for(int i=0;i< 1073741824;i++)
					fos.write(content.getBytes()[2]);			
			}
		
	}
	private void ReadFile(String blockSize, int optType) throws IOException {
		System.out.println("Reading "+blockSize+" from file ....");
		if(optType == 2){ // random
			fis.skip(100);
		}
		byte[] b;
		System.out.println(blockSize);
        
		if(blockSize.equalsIgnoreCase("1B")){
			dt.setNoOfBytes(1);
			fis.read();
		}
		else if(blockSize.equalsIgnoreCase("1KB")){
			dt.setNoOfBytes(1024);
			 	b = new byte[1024];
				fis.read(b);
			}
		else if(blockSize.equalsIgnoreCase("1MB")){
			dt.setNoOfBytes(1048576);
				b = new byte[(int) 1.049e+6];
				fis.read(b);
			}
		else if(blockSize.equalsIgnoreCase("1GB")){
			dt.setNoOfBytes(1073741824);
				b = new byte[(int) 1.074e+9];
				fis.read(b);
		}
		
	}

}
