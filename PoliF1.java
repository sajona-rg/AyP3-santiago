package AyP3;

public class PoliF1 
{
    // atributos
    private int grado;
    private int[] vec;

    public PoliF1(int grado, int coef) {
        this.grado = grado;
        vec = new int[grado + 2];
        vec[0] = grado;
        vec[1] = coef;
    }

    public String mostrarPolinomio()
    {
        String polinomio = "";
        for (int i = 0; i < vec.length; i++) 
        {
            polinomio += "[" + vec[i] + "] ";
        }
        return polinomio;
    }

    public void insertarTermino(int coef, int exp) { }
}    