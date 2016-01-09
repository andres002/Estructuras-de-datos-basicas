package listaSimple;


import java.util.*;
public class Keyboard{

	public int getNum(){
		int num = -1;
		try{
			do{
			Scanner sc = new Scanner(System.in);
			num = sc.nextInt();
			if(num <0)
				System.out.println("Introduzca un numero positivo");
		}while(num < 0);
		}catch(Exception e){
			System.out.println("\nPor favor ingrese solo numeros enteros");
		}
		
				return num;
	}

	public String getString(){
		String dato = new String();
		try{
		Scanner sc = new Scanner(System.in);
		
		dato = sc.nextLine();
		}catch(Exception e){
		}
		return dato;
	}


	
}