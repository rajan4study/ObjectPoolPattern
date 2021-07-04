/**
 * 
 */
package com.study.pattern.objectpool;

/**
 * @author 
 *
 */
public class ObjectPatternApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReausablePool ntonPool = ReausablePool.getInstance();

		for (int i = 0; i < ReausablePool.Default_Pool_Max_Size + 2; i++) {
			Reausable obj1 = ntonPool.accquireObject();
			if (obj1 == null) {
				System.out.println(i + "ton: no onject available");
			} else
				System.out.println(i + "ton: " + obj1.hashCode());
		}

	}

}
