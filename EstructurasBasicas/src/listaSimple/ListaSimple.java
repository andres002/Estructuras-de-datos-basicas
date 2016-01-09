package listaSimple;

/*
Andrés Aguilar Cruz
143385
4°A
*/


class ListaSimple {
    // Referencia  a el node raiz o la cabeza de la lista.
    public Node head;
    private int listCount;
 
    // constructor
    public ListaSimple() {
        // Se asigna la cabeza a un nodo nulo y el contador a 0
        head = new Node(null);
        listCount = 0;
    }
    
    public void addFirst(Object data)
    // Agrega el nodo al principio de la lista.
    {
        Node Temp = new Node(data);
        Node Current = head;
        // Se tiene que posicionar en la cabeza para poder recorrer la lista y llegar al fin
        if(Current.getNext() != null) {
            Temp.setNext(Current.getNext()) ;
        }
        // Asignamos el nuevo nodo como "next" 
        Current.setNext(Temp);
        listCount++;// incrementamos el contador de nodos
    }
 
    public void add(Object data)
    // Agrega el nodo al final de la lista.
    {
        Node Temp = new Node(data);
        Node Current = head;
        // Se tiene que posicionar en la cabeza para poder recorrer la lista y llegar al fin
        while (Current.getNext() != null) {
            Current = Current.getNext();
        }
        // Asignamos el nuevo nodo como "next" 
        Current.setNext(Temp);
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
        
        int cont  = 0;
        Node Current = head;
        // Se tiene que posicionar en la cabeza para poder recorrer la lista y llegar al fin
        while(Current.getNext()!=null &&
               !(data1.equals(((Contact) Current.getNext().getData()).name))) {
             Current = Current.getNext();
            cont++;
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
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return false;
             Current = Current.getNext();
        }
        Current.setNext(Current.getNext().getNext());
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
        int a=index+1;
        for (int i = 1; i < index; i++) {
             Current = Current.getNext();
        }
        Node Temp = new Node(data,Current.getNext());
        Current.setNext(Temp);
        listCount++; // aumenta  el contador de nodos
        return true;
    }


public boolean addOrdenado(Contact data)
    // agrega el elemento en la posición indicada
    {
        
        Node Current = head;
        int a=1;
        String data1 = data.name;
        while(Current.getNext()!=null &&
               (data1.compareTo(((Contact) Current.getNext().getData()).name)) > 0) {
             Current = Current.getNext();
            a++;
        }
        return addPos(a,data1);
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