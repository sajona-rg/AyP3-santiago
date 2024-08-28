package PoliF2;

public class PoliF2 {

    private int[] vec;
    private int nTerminos;

    public PoliF2() {
        vec = new int[1];
        this.nTerminos = 0;
    }

    public String mostrarPolinomio() {
        String polinomio = "";
        for (int i = 0; i < vec.length; i++) {
            polinomio += "[" + vec[i] + "] ";
        }
        return polinomio;
    }

    public void insertarTermino(int coef, int exp) 
    {
        boolean bandera = false;
        int pos = 0;
        if (nTerminos == 0) 
        {
            int[] aux = new int[3];
            nTerminos++;

            aux[0] = nTerminos;
            aux[1] = exp;
            aux[2] = coef;
            vec = aux;
        } else {
            for (int i = 1; i < vec.length; i += 2) {
                if (vec[1] == exp) {
                    bandera = true;
                    pos = i;
                    break;
                } else if (exp > vec[i]) {
                    pos = i;
                    break;
                }
            }
            if (bandera) 
            {
                if(vec[pos+1]+coef == 0)
                {
                    eliminar(exp);
                }else
                    {
                        vec[pos + 1] += coef;
                    }    
            } else
                 {
                    nTerminos++;
                    organizar(pos, exp, coef);
                 }
        }
    }

    public void organizar(int pos, int exp, int coef) {
        int[] aux = new int[nTerminos * 2 + 1];
        aux[0] = nTerminos;

        if (pos == 0) {
            for (int i = 1; i < vec.length; i++) {
                aux[i] = vec[i];
            }
            aux[vec.length] = exp;
            aux[vec.length + 1] = coef;

        } else {
            for (int i = 1; i < pos; i++) {
                aux[i] = vec[i];
            }
            aux[pos] = exp;
            aux[pos + 1] = coef;

            for (int i = pos; i < vec.length; i++) {
                aux[i + 2] = vec[i];
            }
        }
        vec = aux;
    }

    public void eliminar(int exp)
    {   int pos = 0;
        for(int i = 1; i < vec.length; i += 2)
        {
            if(vec[i] == exp)
            {
                pos = i;
                break;        
            }
        }

        if(pos != 0)
        {
            nTerminos --;
            int[] aux = new int [nTerminos * 2 + 1]; 
            aux[0] = nTerminos;

            for(int i = 1; i < pos; i++)
            {
                aux[i] = vec[i];
            }

            for(int i = pos + 2; i < vec.length; i++)
            {
                aux[i-2] = vec[i];
            }
            vec = aux;
        }
    }

}