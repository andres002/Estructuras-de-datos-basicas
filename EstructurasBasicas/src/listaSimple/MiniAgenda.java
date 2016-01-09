/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaSimple;

/**
 *
 * @author Andres
 */
public class MiniAgenda {
    ListaSimple ls;
    public MiniAgenda(){
        ls = new ListaSimple();
    }
    private void menu(){
        System.out.println("Por favor elija una opción");
        System.out.println("1.-Añadir Ordenadamente");
        System.out.println("2.-Añadir al final");
        System.out.println("3.-Añadir al inicio");
        System.out.println("4.- Añadir en una posición exacta");
        System.out.println("5.- Eliminar");
        System.out.println("6.- Listar");
        System.out.println("7.- Salir");
        cases();
    }
    
    private Contact contactNew(){
        Keyboard k = new Keyboard();
        System.out.println("Por favor Introduzca los datos del contacto");
        System.out.print("Nombre:  ");
        String name = k.getString();
        System.out.print("\nNumero:  ");
        String number = k.getString();
        Contact c  = new Contact(name, number);
        return c;
    }
    
    private void cases(){
        boolean bandera = true;
        Keyboard k = new Keyboard();
        int opc = k.getNum();
        
        switch(opc){
            case 1:
                ls.addOrdenado(contactNew());
            break;
            case 2:
                ls.add(contactNew());
            break;
            case 3:
                ls.addFirst(contactNew());
            break;
            case 4:
                System.out.println("Por favor Ingrese la posición que desea,"
                        + " en dado de ser una posicion invalida se añadirá añ final de la lista ");
                opc = k.getNum();
                while(opc < 1){
                    System.out.println("Ingrese solo números positivos");
                    opc = k.getNum();
                }
                ls.addPos(opc, contactNew());
            break;
            case 5:
            System.out.println("Por favor Ingrese el nombre del Contacto a Eliminar");
               if(ls.searchRemove(k.getString())){
                   System.out.println("Elimanción realizada con exito");
               }else{
                   System.out.println("Eliminación no realizada");
               }
            break;
            case 6:
                Node n = ls.head;
                System.out.println("\n\n\n");
                while(n.getNext() != null){
                    n = n.getNext();
                    System.out.println("----------------------------------------");
                    Contact x = (Contact)n.getData();
                    System.out.println("Nombre: " + x.name);
                    System.out.println("Telefono: " + x.number);  
                    
                }
                System.out.println("\n\nTotal de contactos = " + ls.size()+"\n");
            break;
            case 7:
                bandera = false;
                break;
            default:
                System.out.println("Opcion Invalida Intentelo de nuevo");
            break;
        }
        if(bandera)
            menu();
        
    }
    public void start(){
       System.out.println("Bienvenido a la Mini Agenda");
       menu();
    }
    
   public static void main(){
       System.out.println("Bienvenido a la Mini Agenda");
       MiniAgenda m = new MiniAgenda();
       m.menu();
   }
}
