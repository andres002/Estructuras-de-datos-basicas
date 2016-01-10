/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasbasicas;

import ArbolBD.PrincipalABD;
import listaSimple.MiniAgenda;
import listaDoble.Agendita;
import java.util.Scanner;
import Pila.LeePila;
/**
 *
 * @author Andres
 */
public class EstructurasBasicas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------BIENVENIDO-------");
        System.out.println("1. Pilas\n2. Colas\n3. Lista Simple\n4. Lista Doble\n5. Árbol\n6. Salir");
        System.out.println("-------------------------");
        System.out.print("\nSeleccione una opción: ");
        int opc = Integer.parseInt(sc.nextLine().replaceAll(" ", ""));
        System.out.println("\nIngrese la palabra FIN al finalizar");
        
        switch(opc){
            case 1:
                boolean bandera = true;
                LeePila a = new LeePila();
                while(bandera){
                    bandera = a.leer();
                }
                a.imprimir();
            break;
                
            case 2:
                boolean b=false;
		MainQueue mc= new MainQueue();
		do{
			b=mc.leer();
		}while(b==false);
		mc.imprimir();
            break;
                
            case 3:
                MiniAgenda mini = new MiniAgenda();
                mini.start();
            break;
                
            case 4:
                Agendita agendita = new Agendita();
                agendita.start();
            break;
                
            case 5:
                PrincipalABD p = new PrincipalABD();
                p.menu();
            break;
            case 6:
                System.exit(0);
                break;
                
            default:
                
            break;
        }
    }
    
}
