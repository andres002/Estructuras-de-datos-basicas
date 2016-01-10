/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;


import java.util.Scanner;

/**
 *
 * @author hugo
 */
public class LeePila {
    
    Pilas a = new Pilas(100);
    String dato;
    public boolean leer(){
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese su cadena e ingrese Fin para finalizar");
            dato = s.nextLine();
            if(dato.equals("Fin")){
                return false;
        }else{
            a.push(dato);
            }
        return true;
          
    }
    public void imprimir(){
        while(!a.isEmpty()){
            System.out.println(a.pop());
        }
    
    }  
}
