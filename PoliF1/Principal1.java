package PoliF1;

public class Principal1
{ 
  public static void main(String[] args) {

   
        PoliF1 pol1 = new PoliF1(0, -8);
        pol1.insertarTermino(3,2);
        pol1.insertarTermino(2, 4);

       System.out.println("pol1\n"+ pol1.mostrarPolinomio());
        
        PoliF1 pol2 = new PoliF1(2, 4);
        pol2.insertarTermino(2,5);
        pol2.insertarTermino(3, 4);
     
        System.out.println("pol2\n"+pol2.mostrarPolinomio());

        PoliF1 suma;

        suma = pol1.sumar(pol2);

        System.out.println("suma\n"+suma.mostrarPolinomio());
        
          pol1.eliminarTermino(2);
          System.out.println(pol1.mostrarPolinomio());
         
        PoliF1 producto;
        producto = pol1.multiplicar(pol2);

        System.out.println("producto: \n"+producto.mostrarPolinomio());

    }
}

