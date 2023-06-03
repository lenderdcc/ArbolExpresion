package arboldeexpresiones;

import java.util.Stack;
import java.util.Scanner;

public class ArbolBinario {

    Scanner sc = new Scanner(System.in);
    public NodoArbol raiz;
    Stack<Character> pilaCaracter = new Stack<Character>();
    Stack<NodoArbol> pilaArbol = new Stack<NodoArbol>();

    public ArbolBinario() {
        this.raiz = null;
    }

    public ArbolBinario(String expresion) throws Exception {
        this.raiz = crearArbolExpresion();
    }

    public NodoArbol raizArbol() {

        return raiz;
    }

    public boolean esVacio() {

        return raiz == null;

    }

    public static NodoArbol nuevoArbol(NodoArbol ramaIzq, char Caracter, NodoArbol ramaDer) {

        return new NodoArbol(ramaIzq, Caracter, ramaDer);
    }

    private int prioridad(char caracter) {
        int p = 100;
        switch (caracter) {
            case '^':
                p = 30;
                break;
            case '*':
            case '/':
                p = 20;
                break;
            case '+':
            case '-':
                p = 10;
                break;

            default:
                p = 0;
        }
        return p;
    }

    private boolean esOperador(char caracter) {
        boolean resultado;
        switch (caracter) {
            case '(':
            case '^':
            case '*':
            case '/':
            case '+':
            case '-':
                resultado = true;
                break;
            default:
                resultado = false;
        }
        return resultado;
    }

    public void ValidarExpresion(String expresion) throws Exception {
        int contadorIzq = 0, contadorDer = 0;
        char caracter;
        for (int i = 0; i < expresion.length(); i++) {
            caracter = expresion.charAt(i);
            if (caracter == '(') {
                contadorIzq++;
            }
            if (caracter == ')') {
                contadorDer++;
            }
        }
        if (contadorIzq != contadorDer) {
            throw new Exception("Parentesis incompletos, revisar expresion");
        }
    }

    public void descomponerExp() throws Exception {
        String expresion;
        String resultado = "";
        char caracter;
        System.out.println("\n" + "Ingrese la expresion");
        expresion = sc.nextLine();
        ValidarExpresion(expresion);

        for (int i = 0; i < expresion.length(); i++) {
            caracter = expresion.charAt(i);
            if (caracter != ' ') {
                if (!esOperador(caracter) && caracter != ')') {
                    resultado += caracter;
                }
                if (esOperador(caracter)) {
                    if (pilaCaracter.isEmpty()) {
                        pilaCaracter.push(caracter);
                    } else {
                        if (caracter == '(') {
                            pilaCaracter.push(caracter);
                        } else if (prioridad(caracter) > prioridad(pilaCaracter.peek())) {
                            pilaCaracter.push(caracter);
                        } else if (prioridad(caracter) <= prioridad(pilaCaracter.peek())) {
                            resultado += pilaCaracter.pop();
                            pilaCaracter.push(caracter);
                        }
                    }
                }
                if (caracter == ')') {
                    while (!pilaCaracter.isEmpty() && pilaCaracter.peek() != '(') {
                        resultado += pilaCaracter.pop();
                    }
                    if (pilaCaracter.peek() == '(') {
                        pilaCaracter.pop();
                    }
                }
            }
        }
        while (!pilaCaracter.isEmpty()) {
            resultado += pilaCaracter.pop();
        }

        for (int i = resultado.length() - 1; i >= 0; i--) {
            pilaCaracter.push(resultado.charAt(i));
        }
    }

    public NodoArbol crearArbolExpresion() throws Exception {
        descomponerExp();
        char caracter;
        NodoArbol Arbol = new NodoArbol();
        NodoArbol operador = new NodoArbol();
        NodoArbol operando1 = new NodoArbol();
        NodoArbol operando2 = new NodoArbol();

        while (!pilaCaracter.isEmpty()) {
            if (!esOperador(pilaCaracter.peek())) {
                pilaArbol.push(new NodoArbol(pilaCaracter.pop()));
            } else if (esOperador(pilaCaracter.peek())) {
                operando2 = pilaArbol.pop();
                operando1 = pilaArbol.pop();
                operador.Caracter = pilaCaracter.pop();
                Arbol = nuevoArbol(operando1, operador.Caracter, operando2);
                pilaArbol.push(Arbol);
            }
        }
        operador = pilaArbol.pop();
        return operador;
    }
}
