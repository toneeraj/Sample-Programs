package _Practice;

import javax.management.InstanceAlreadyExistsException;

public class SingletonTest {

	private static SingletonTest instance = null;
	
	private SingletonTest() throws InstanceAlreadyExistsException {
		if (instance != null) {
			throw new InstanceAlreadyExistsException();
		}
		
	}
	
	public synchronized static SingletonTest createInstance () throws InstanceAlreadyExistsException {
		if (instance == null) {
			instance = new SingletonTest();
		} 
		return instance;
	}
}
