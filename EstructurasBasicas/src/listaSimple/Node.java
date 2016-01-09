package listaSimple;

/*
Andrés Aguilar Cruz
143385
4°A
*/
//java org.junit.runner.JUnitCore [test class name]

public class Node{
	

        //Referencia al siguiente elemento o a NULL si es el ultimo
        Node next;
        Object data;
        // Node constructor
        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }
        // Constructor que incluye el siguiente nodo
        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }
 
        public Object getData() {
            return data;
        }
 
        public void setData(Object dataValue) {
            data = dataValue;
        }
 
        public Node getNext() {
            return next;
        }
 
        public void setNext(Node nextValue) {
            next = nextValue;
        }
    
}