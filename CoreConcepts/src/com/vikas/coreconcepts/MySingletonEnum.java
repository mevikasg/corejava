/**
 * 
 */
package com.vikas.coreconcepts;

/**
 * @author vgupta
 *
 */
public enum MySingletonEnum {
	INSTANCE;

	public void print(){
		System.out.println("Enum Singleton accessed ...");
	}
	
}
