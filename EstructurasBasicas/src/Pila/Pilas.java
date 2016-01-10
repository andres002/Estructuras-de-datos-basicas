/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;



/**
 *
 * @author hugo
 */
public class Pilas {
    private String pila[];
        public Pilas(){} 
	
	private int tope;
	public Pilas(int capacidad){
		pila = new String[capacidad];
		tope =-1;
	}
	public boolean isEmpty(){
		return tope== -1;
	}
	public void push(String i){
		if(tope+1<pila.length)
			pila[++tope]=i;
	}
	
	public String pop(){
		if(isEmpty())
			return "";
		return pila[tope--];	
	}
	/*public String toString(){
		return new (pila,0,tope+1);
	}*/
    
}
