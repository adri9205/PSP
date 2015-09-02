package com.programa;

public class CuentaVacias {
	int lineasVa;
	public void CuentaVacia(){
		lineasVa=1;
	}
	public int CuentaVaciaSum(){
		return lineasVa;
	}
	
	public int cuentaV(int linea){
		lineasVa+=linea;
	return lineasVa;	
	}
}
