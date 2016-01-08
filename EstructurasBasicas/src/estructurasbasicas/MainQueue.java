/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasbasicas;

import java.util.Scanner;

/**
 *
 * @author W8
 */
public class MainQueue {
    MyQueue q=new MyQueue(100);
	String s;
	Scanner x=new Scanner (System.in);
	int comp=0, compara;

	public boolean leer() throws Exception{
		System.out.println("Ingrese la Cadena");
		s=x.nextLine();
		if (s.equals("FIN")){
			return true;
		}else{
			if(q.isEmpty()){
				q.enqueue(s);
			}else{
				ordenaCadena();
			}
		}return false;
	}

	public void ordenaCadena() throws Exception{
		MyQueue aux = new MyQueue(100);
		boolean b=true;
		String cad;
		while(!q.isEmpty()){
			cad=q.dequeue().toString();
			comp=s.compareTo(cad);
			if(comp==0){
				if (b){
					aux.enqueue(s);
					b=false;
				}
				aux.enqueue(cad);

			}else{
				if (q.isEmpty()){
					compara=-1;
				}else{
					compara=s.compareTo(q.peek().toString());
				}if (comp>0 & compara<0 & b){
					aux.enqueue(cad);
					aux.enqueue(s);
					b=false;
				}else{
					if (comp<0 & b){
						aux.enqueue(s);
						b=false;
					}
					aux.enqueue(cad);
				}
			}
		}
		q=aux;
	}

	public void imprimir() throws Exception{
		while(q.isEmpty()==false){
			System.out.println(q.dequeue());
		}
	}
/*
	public static void main(String []args) throws Exception{
		
        }*/
}
