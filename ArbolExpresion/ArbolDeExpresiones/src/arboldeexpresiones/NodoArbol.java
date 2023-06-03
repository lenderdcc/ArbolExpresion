package arboldeexpresiones;

public class NodoArbol {

    public char Caracter;
    public NodoArbol HijoIzq;
    public NodoArbol HijoDer;

    public NodoArbol() {
    }

    public NodoArbol(char caracter) {
        Caracter = caracter;
        HijoIzq = HijoDer = null;
    }

    public NodoArbol(NodoArbol ramaIzq, char caracter, NodoArbol ramaDer) {
        Caracter = caracter;
        HijoIzq = ramaIzq;
        HijoDer = ramaDer;
    }

    public char getCaracter() {
        return Caracter;
    }

    public void setCaracter(char caracter) {
        this.Caracter = caracter;
    }

    public NodoArbol getHijoIzq() {
        return HijoIzq;
    }

    public void setHijoIzq(NodoArbol HijoIzq) {
        this.HijoIzq = HijoIzq;
    }

    public NodoArbol getHijoDer() {
        return HijoDer;
    }

    public void setHijoDer(NodoArbol HijoDer) {
        this.HijoDer = HijoDer;
    }

    @Override
    public String toString() {
        return Caracter + "{" + HijoIzq + "{" + HijoDer + '}';
    }


    public void printInOrder() {
        if (HijoIzq != null) {
            HijoIzq.printInOrder();
        }
        System.out.print(Caracter);
        if (HijoDer != null) {
            HijoDer.printInOrder();
        }
    }
    
    public void printPreOrder() {
        System.out.print(Caracter);
        if (HijoIzq != null) {
            HijoIzq.printPreOrder();
        }
        if (HijoDer != null) {
            HijoDer.printPreOrder();
        }
    }

    
     
    public void printPosOrder() {
        if (HijoIzq != null) {
            HijoIzq.printPosOrder();
        }
        if (HijoDer != null) {
            HijoDer.printPosOrder();
        }
        System.out.print(Caracter);
    }

}
