/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaDoble;

/**
 *
 * @author Andres
 */
public class ListaDoble {
    // Referencia  a el node raiz o la cabeza de la lista.
    public Node head,rear;
    private int listCount;
 
    // constructor
    public ListaDoble() {
        // Se asigna la cabeza a un nodo nulo y el contador a 0
        head = new Node(null);
        rear = new Node(null);
        listCount = 0;
    }
    
    public void addFirst(Object data)
    // Agrega el nodo al principio de la lista.
    {
        Node Temp = new Node(data);
        Node Current = head;
        Node Current2 = rear;
        
        if(Current.getNext() != null) {
            Temp.setNext(Current.getNext()) ;
            Current.getNext().setPrev(Temp);
        }else{
             Current2.setPrev(Temp);
        }
        // Asignamos el nuevo nodo como "next" 
        Current.setNext(Temp);
        listCount++;// incrementamos el contador de nodos
    }
 
    public void add(Object data)
    // Agrega el nodo al final de la lista.
    {
        Node Temp = new Node(data);
        Node Current = rear;
        Node Current2 = head;
        
        if (Current.getPrev()!= null) {
            Temp.setPrev(Current.getPrev()) ;
            Current.getPrev().setNext(Temp);
        }else{
            Current2.setNext(Temp);
        }
        // Asignamos el nuevo nodo como "next" 
        Current.setPrev(Temp);
        listCount++;// incrementamos el contador de nodos
    }
 
     public Node get(int index)
    // Regresa el nodo en la posición indicada por index
    {
        if (index <= 0)
            return null;
 
        Node Current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return null;
             Current = Current.getNext();
        }
        return Current;
    }
     
     public boolean searchRemove(String data1)
    // remueve el elemento en la posición indicada
    {
        boolean encontrado = false;
        int cont  = 1;
        Node Current = head;
        // Se tiene que posicionar en la cabeza para poder recorrer la lista y llegar al fin
        while(Current.getNext()!=null &&
               !(data1.equals(((Contact) Current.getNext().getData()).name))) {
             Current = Current.getNext();
            cont++;
        }
        if(Current.getNext() == null && !(data1.equals(((Contact) Current.getData()).name))){
            return false;
        }
        
        return remove(cont);
        
    }
     
 
    public boolean remove(int index)
    // remueve el elemento en la posición indicada
    {
        // 
        if (index < 1 || index > size())
            return false;
        Node Current = head;
        Node Current2 = rear;
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return false;
             Current = Current.getNext();
        }
        
        if(index != size()){
            Current.setNext(Current.getNext().getNext());
            if(index != 1 ){
             Current.getNext().setPrev(Current);
            }else{
                 Current.getNext().setPrev(null);
            }
        }else{
            Current.setNext(null);
            if(index != 1){
                Current2.setPrev(Current);    
            }else{
                 Current2.setPrev(null);    
            }
            
        }
       
       

        listCount--; // disminuimos el contador de nodos
        return true;
    }

    public boolean addPos(int index, Object data)
    // agrega el elemento en la posición indicada
    {
        //
        if (index < 1 )
            return false;
        if (index > size()){
            add(data); 
            return true;
        }
        Node Current = head;
       // int a=index+1;
        for (int i = 1; i < index; i++) {
             Current = Current.getNext();
        }
        Node Temp;
        if(index == 1){
            Temp = new Node(data,Current.getNext(),null);
        }else{
            Temp = new Node(data,Current.getNext(),Current);
        }
        Current.getNext().setPrev(Temp);
        Current.setNext(Temp);
        listCount++; // aumenta  el contador de nodos
        return true;
    }


public boolean addOrdenado(Contact data)
    // agrega el elemento en la posición indicada
    {
        
        Node Current = head;
        int a=1;
        String data1 = data.name.toUpperCase();
        while(Current.getNext()!=null &&
               (data1.compareTo(((Contact) Current.getNext().getData()).name.toUpperCase())) > 0) {
             Current = Current.getNext();
            a++;
        }
        return addPos(a,data);
    }


 
    public int size()
    // returns the number of elements in this list.
    {
        return listCount;
    }
 
    public String toString() {
        Node Current = head.getNext();
        String output = "";
        while (Current != null) {
            output += "[" + Current.getData().toString() + "]";
            Current = Current.getNext();
        }
        return output;
    }
    
}
