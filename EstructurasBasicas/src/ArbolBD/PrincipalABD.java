package ArbolBD;


import java.util.Scanner;

public class PrincipalABD{
	 ArbolB arbol = new ArbolB();
    	Persistencia se = new Persistencia();
    	Customers cus = new Customers();

  	public static void main(String[] args) {
  		PrincipalABD p = new PrincipalABD();
  		p.menu();
        
  	}

    public void menu(){
        System.out.println("------------------------------------");
        System.out.print("\nIntroduzca una opcion: ");
        System.out.println("\n1. Leer registros");
        System.out.println("2. Imprimir lista");
        System.out.println("3. Limpiar arbol");
        System.out.println("4. Guardar el arbol");
        System.out.println("5. Recuperar el arbol");
         System.out.println("------------------------------------");
        int opc = leerNumero();
        switch(opc){
            case 1: leerRegistros();
                    break;
            case 2: imprimir();
                    break;
            case 3:
                    limpiar();
                    break;
            case 4: 
                    guardarA();
                    break;
            case 5: 
                    leer();
                    break;
        }
        opciones();
        
    }

    
    public void limpiar(){
        arbol = null;
    }

    public void imprimir(){
        System.out.println("Seleccione una opción de impresión");
        System.out.println("1. Inorder \n 2. Postorder \n 3. Preorder");
        int opc = leerNumero();
    	try{
            switch(opc){
                case 1:
                    arbol.inOrder(); 
                    break;
                case 2:
                    arbol.postOrder();
                    break;
                case 3:
                    arbol.preOrder();
                    break;
                default:
                    System.out.println("Seleccione una opción válida");
                    imprimir();
                            
                    break;
            }
    		
    	}catch(Exception e){
    		 System.out.println("El arbol esta vacio");
    	}

    }

    public void leerRegistros(){
    	if(arbol == null){
    		arbol = new ArbolB();
    	}
        cus.consultarDatos();
        while(cus.nextData()){
            arbol.insertar(new Customers( cus.getCustomerID(),  
                cus.getCompanyName(),  
                cus.getContactName(), 
                cus.getContactTitle(), 
                cus.getAddress(), cus.getCity(),
                cus.getRegion(),
                cus.getPostalcode(),
                cus.getCountry (),
                cus.getPhone(),
                cus.getFax()));
            //c.Imprimir();
        }
        System.out.println("Se han leido los registros");
    }
    
    public void opciones(){
    	System.out.println("\n\n\nDesea realizar otra accion: 1. Si 2.No");
        int opc =leerNumero();
        if(opc == 1){
            menu();
        }else{
        	if(opc !=2)
        		opciones();
        }
    }

    private int leerNumero(){
    	Scanner input = new Scanner(System.in);
    	int numero = -1;
    	try{
    		do{
    			
    		numero = input.nextInt();
    		}while(numero <0);
    		return numero;
    	}catch(Exception e){
    		System.out.println("Opcion no valida, intente otra vez");
    		return leerNumero();
    	}
    }
    private String leerCadena(){
    	Scanner input = new Scanner(System.in);
    	String cadena = null;
    	try{
    		cadena =input.nextLine();
    		return cadena;
    	}catch(Exception e){
    		System.out.println("Opcion no valida, intente otra vez");
    		return leerCadena();
    	}
    }

    public void guardarA(){
    	System.out.println("Indique un nombre de archivo con extencion");
    	String aux = leerCadena();
    	//System.out.println(aux);
        se.guardar(arbol,aux);
    }
    public void leer(){
    	System.out.println("Indique el nombre del archivo a leer con extencion");
    	String aux = leerCadena();
        arbol = (ArbolB)se.leer(aux);
    }



}
