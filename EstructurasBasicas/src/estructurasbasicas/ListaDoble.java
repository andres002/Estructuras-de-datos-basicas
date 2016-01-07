/*
Andres Aguilar Cruz 
143385
4° A 
Estructura de Datos
Universidad Politécnica de Chiapas

*/



class ListaDoble<T> {
    // Referencia  a el node raiz o la cabeza de la lista.
    private Node<T> head,rear;
    private int listCount;
 
    // constructor
    public ListaDoble() {
        // Se asigna la cabeza a un nodo nulo y el contador a 0
        head = new Node<T>(null);
        rear = new Node<T>(null);
        listCount = 0;
    }
 
    public void add(T data)
    // Agrega el nodo al final de la lista.
    {
        
        
        if(listCount == 0){
        	Node<T> Temp = new Node<T>(data);
        	rear.setPrev(Temp);
        	head.setNext(Temp);
        }else {

        	Node<T> Temp = new Node<T>(data,null,rear.getPrev());
        	rear.getPrev().setNext(Temp);
        	rear.setPrev(Temp);
        }
       
        listCount++;// incrementamos el contador de nodos
    }
 
    public Node<T> get(int index)
    // Regresa el nodo en la posición indicada por index
    {
        if (index <= 0)
            return null;
 
        Node<T> Current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return null;
             Current = Current.getNext();
        }
        return Current;
    }
 
    public boolean remove(int index)
    // remueve el elemento en la posición indicada
    {
        // 
        if (index < 1 || index > size())
            return false;
        Node<T> Current = head;
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return false;
             Current = Current.getNext();
        }
        if(index == size()){
        	Current.setNext(null);
        	rear.setPrev(Current);

        }else{
        	 Current.setNext(Current.getNext().getNext());

            if (index == 1){
            	Current.getNext().setPrev(null);
       		}else{
       			 Current.getNext().getNext().setPrev(Current);
       		}

        }
       
        listCount--; // disminuimos el contador de nodos
        return true;
    }

 	 public boolean addPos(int index, T data)
    // agrega el elemento en la posición indicada
    {
        //
        if (index < 1 )
            return false;
        if (index > size()){
            add(data); 
            return true;
        }
        Node<T> Current = head;
        
        for (int i = 1; i < index; i++) {
             Current = Current.getNext();
        }
        Node<T> Temp ;
        if(index == 1){
        	Temp = new Node<T>(data,Current.getNext(),null);
        }else{
        	Temp = new Node<T>(data,Current.getNext(),Current);
        }
        Current.getNext().setPrev(Temp);
        Current.setNext(Temp);
        listCount++; // aumenta  el contador de nodos
        return true;
    }

  
	public <Object extends Comparable<Object>> int addOrdenado(T data)
    // agrega el elemento en la posición indicada
    {
        
        Node<T> Current = head;
        int a=1;
        boolean bandera = true;
        //Object data1 =  (Object) data;
        String classname = data.getClass().getName();
        if(classname.equals("Index")){
            Index i = (Index)data;
            String ident = i.getIdentifier();
            if (Current.getNext()!=null ){
                Index i2 = (Index)Current.getNext().getData();
                String ident2 = i2.getIdentifier();
                while(Current.getNext()!=null &&
                    ident.compareTo(ident2)> 0) {
                    Current = Current.getNext();
                    if(Current.getNext()!=null){
                        i2 = (Index)Current.getNext().getData();
                        ident2 = i2.getIdentifier();
                    }
                    a++;
                }
                if (ident.compareTo(ident2) == 0){
                //System.out.println("el nodo no fue añadido");
                return a;
                }
            }

        }else if(classname.equals("People")){
                People p = (People)data;
                String peo = p.getName();
                if (Current.getNext()!=null ){
                    People p2 = (People)Current.getNext().getData();
                    String peo2 = p2.getName();
                   // System.out.println("NOmbre de comprobacion " + peo2);
                    while(Current.getNext()!=null &&
                        peo.compareTo(peo2)> 0) {
                        Current = Current.getNext();
                        if(Current.getNext()!=null){
                            p2 = (People)Current.getNext().getData();
                            peo2 = p2.getName();
                        }
                        a++;
                    }
                }
            }else{

                Object data1 =  (Object) data;
                while(Current.getNext()!=null &&
                    data1.compareTo((Object) Current.getNext().getData()) > 0) {
                    Current = Current.getNext();
                    a++;
                }
            }
    
        addPos(a,data);
        return -1;
    
        
        
    }



    public int size()
    // returns the number of elements in this list.
    {
        return listCount;
    }
 


 
    public String toString() {
        Node<T> Current = head.getNext();
        String output = "";
        while (Current != null) {
            output += "[" + Current.getData().toString() + "]";
            Current = Current.getNext();
        }
        return output;
    }

    public String toStringRear() {
        Node<T> Current = rear.getPrev();
        //System.out.println(rear.getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getPrev().getData().toString());
        String output = "";
        int aux = size();
         while (Current != null) {
            output += "[" + Current.getData().toString() + "]";
            Current = Current.getPrev();
        }
      /*  while (aux > 0) {
            output += "[" + Current.getData().toString() + "]";
          //  if(aux > 0){
          	
            	Current = Current.getPrev();
            	aux--;
            //}
            
        }*/
        return output;
    }
    
}