package com.hskj.util;

public class DiffModel {
	private String schemataInfo;
	
	public String getSchemataInfo() {
		return schemataInfo;
	}

	public void setSchemataInfo(String schemataInfo) {
		this.schemataInfo = schemataInfo;
	}
	

	public int f() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((schemataInfo == null) ? 0 : schemataInfo.hashCode());
		return result;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		final DiffModel other = (DiffModel) obj;
//		if (schemataInfo == null) {
//			if (other.schemataInfo != null)
//				return false;
//		} else if (!schemataInfo.equals(other.schemataInfo))
//			return false;
//		return true;
//	}

	public static void main(String[] a){
		DiffModel d = new DiffModel();
		d.setSchemataInfo("jfd");
		System.out.println(d);
		System.out.println(d.f());
		
		d.setSchemataInfo("jfd");
		System.out.println(d);
		System.out.println(d.f());
		
	}
	
}
