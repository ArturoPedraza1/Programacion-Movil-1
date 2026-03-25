//Pedraza Cruz José Arturo

public class Calculadora {
   
    public double sumar(double n1, double n2){
        return n1 + n2;
    }
   
    public void restar(double n1, double n2){
        System.out.println(n1-n2); }
   
    public static double multiplicar(double n1, double n2){
        return n1 * n2;
    }
   
    public static double dividir(double n1, double n2){
        return n1 / n2;
    }   
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        c.restar(5, 2);
        double res = c.sumar(5, 3);
        System.out.println(res);
       
        dividir(10,2);
        c.dividir(10,2);
        Calculadora.dividir(2,1);
       
        double res2 = multiplicar(2, 3);
        System.out.println(res2);
    }
}