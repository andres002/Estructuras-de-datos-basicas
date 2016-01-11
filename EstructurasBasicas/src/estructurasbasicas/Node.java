public class Node <T>{
	

        //Referencia al siguiente elemento o a NULL si es el ultimo
        Node next, prev;
        T data;
        // Node constructor
        public Node(T dataValue) {
            next = null;
            prev = null;
            data = dataValue;
        }
        // Constructor que incluye el siguiente nodo
        public Node(T dataValue, Node nextValue, Node prevValue) {
            next = nextValue;
            prev = prevValue;
            data = dataValue;
        }
 
        public T getData() {
            return data;
        }
 
        public void setData(T dataValue) {
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