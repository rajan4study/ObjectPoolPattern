package com.study.pattern.objectpool;

import java.util.ArrayList;

/**
 * @author 
 *
 */
public class ReausablePool {

	public static final int Default_Pool_Max_Size = 10;

	private static int poolSize = Default_Pool_Max_Size;

	private ArrayList<Reausable> reausableObj;

	protected static ReausablePool pool = null;

	private ReausablePool() {
		System.out.println("Pool created");
		reausableObj = new ArrayList<>();
	}

	public static int getPoolSize() {
		return poolSize;
	}

	public static void setPoolSize(int poolSize) {
		ReausablePool.poolSize = poolSize;
	}

	public synchronized Reausable accquireObject() {
		for (Reausable obj : reausableObj) {
			if (!obj.isInUse()) {
				return obj;
			}
		}
		if (reausableObj.size() > getPoolSize()) {
			return null;
		}
		Reausable obj = new Reausable();
		obj.setInUse(true);
		reausableObj.add(obj);
		return obj;
	}

	public void releaseObject(Reausable obj) {
		int index = reausableObj.indexOf(obj);
		if (index == -1) {
			return;
		}
		Reausable visitor = reausableObj.get(index);
		visitor.setInUse(false);
	}

	protected static ReausablePool getInstance() {
		if (pool == null) {
			synchronized (ReausablePool.class) {
				if (pool == null)
					pool = new ReausablePool();
			}

		}
		return pool;
	}
}
