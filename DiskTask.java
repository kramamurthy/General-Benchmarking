package edu.iit.cc;

public class DiskTask {
	
	private String blockSize; //1B,1KB,1MB,1GB
	private String operation; //read or write
	private int optType; // 1 for sequential or 2 for random 
	private long noOfBytes;
	public long getNoOfBytes() {
		return noOfBytes;
	}
	public void setNoOfBytes(long noOfBytes) {
		this.noOfBytes = noOfBytes;
	}
	public String getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(String blockSize) {
		this.blockSize = blockSize;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getOptType() {
		return optType;
	}
	public void setOptType(int optType) {
		this.optType = optType;
	}
	
}
