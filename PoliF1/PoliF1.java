package PoliF1;

public class PoliF1 {
    // atributos
    private int grado;
    private int[] vec;

    public PoliF1(int grado, int coef) {
        this.grado = grado;
        vec = new int[grado + 2];
        vec[0] = grado;
        vec[1] = coef;
    }

    public String mostrarPolinomio() {
        String polinomio = "";
        for (int i = 0; i < vec.length; i++) {
            polinomio += "[" + vec[i] + "] ";
        }
        return polinomio;
    }

    public void insertarTermino(int coef, int exp) {
        if (exp <= grado) {

            if (vec[vec.length - exp - 1] + coef == 0) {
                eliminarTermino(exp);

            } else {
                vec[vec.length - exp - 1] += coef;

            }
        } else {
            int[] aux = new int[exp + 2];

            for (int i = 0; i <= grado; i++) // grado = grado del primer vector.
            {
                aux[aux.length - i - 1] = vec[vec.length - i - 1];
            }

            grado = exp;
            aux[0] = grado;
            aux[1] = coef;
            vec = aux;
        }

    }

    public void eliminarTermino(int exp) {
        vec[grado + 1 - exp] = 0;

        if (exp == grado) {
            reajustar();
        }

    }

    public void reajustar() {
        boolean bandera = false;
        int conta = 0;

        for (int i = 1; i < vec.length; i++) {
            if (vec[i] != 0) {
                bandera = true;
                break;
            }
            conta++;
        }

        if (bandera) {
            int[] aux = new int[grado - conta + 2];
            for (int i = vec.length - 1; i > conta; i--) {
                aux[i - conta] = vec[i];
            }
            aux[0] = grado - conta;
            grado = aux[0];
            vec = aux;
        } else {
            int[] aux = new int[1];
            aux[0] = -1;
            grado = -1;
            vec = aux;
        }
    }

    public PoliF1 sumar(PoliF1 pol) {
        PoliF1 suma = new PoliF1(0, 0);

        for (int i = 1; i < vec.length; i++) {
            suma.insertarTermino(vec[i], grado - i + 1);
        }

        for (int i = 1; i < pol.vec.length; i++) {
            suma.insertarTermino(pol.vec[i], pol.grado - i + 1);

        }

        return suma;
    }

    public PoliF1 multiplicar(PoliF1 pol) {
        PoliF1 producto = new PoliF1(grado + pol.grado, 0);
        int coef, exp;
        for (int i = 1; i < vec.length; i++) {
            for (int j = 1; j < pol.vec.length; j++) {
                coef = vec[i] * pol.vec[j];
                exp = (grado - i + 1) + (pol.grado - j + 1);

                producto.insertarTermino(coef, exp);
            }
        }
        return producto;
    }

}