package listaDoble;

/*
Andrés Aguilar Cruz
143385
4°A
*/
//java org.junit.runner.JUnitCore [test class name]

public class Node{
	

        //Referencia al siguiente elemento o a NULL si es el ultimo
        Node next,prev;
        Object data;
        // Node constructor
        public Node(Object dataValue) {
            next = null;
            prev = null;
            data = dataValue;
        }
        // Constructor que incluye el siguiente nodo
        public Node(Object dataValue, Node nextValue, Node prevValue) {
            next = nextValue;
            prev = prevValue;
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
        
        public Node getPrev(){
            return prev;
        }
 
        public void setNext(Node nextValue) {
            next = nextValue;
        }
        
        public void setPrev(Node prevValue){
            prev = prevValue;
        }
    
}