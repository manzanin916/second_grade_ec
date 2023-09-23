package basic;
import java.util.List;
import java.util.ArrayList;

public class secondGrade {

    public static void main(String[] args){

        // sistema de manejo de excepciones, capturamos el problema y enseñamos la excepción personalizada;
        try {
            List<Double> resultado = secondGradeEc(1, 2, 3);
            System.out.println("-> Estas son las soluciones: " + resultado);
        }catch(solucionImaginaria ref){

            // get.Message() es un método de la superclase Throwable, obtiene la información de la excepción;
            System.out.println(ref.getMessage());
        }
    }

    // Usamos throws para indicar que se va a lanzar una excepción si las cosas no salen bien (solución imaginaria);
    public static List<Double> secondGradeEc(double a, double b, double c) throws solucionImaginaria {

        List<Double> soluciones = new ArrayList<>();
        
        // necesitamos una referencia a la parte critica donde se puede ver la raiz negativa;
        double parteCritica = Math.sqrt(Math.pow(b, 2) - 4*a*c);

        double xPositiva = ((-b) + parteCritica) / (2.0*a);
        double xNegativa = ((-b) - parteCritica) / (2.0*a);

        // En caso de que el valor sea imaginario (NaN), lanzamos una excepción; de lo contrario, lo mostramos;
        if(parteCritica >= 0){
            soluciones.add(xPositiva);
            soluciones.add(xNegativa);

            return soluciones;
        }

        // lanzamos la excepción (no hace falta el else);
        throw new solucionImaginaria("-> No hay solución real");
    }

}

// relación de herencia (subclase => superclase; hereda los atributos de la superclase Exception);
class solucionImaginaria extends Exception {
    public solucionImaginaria(String mensaje){
        super(mensaje);
    }
}

/*
Se usa el sistema de herencia entre clases para poder usar los atributos que debe de tener una excepción,
en el caso de que no usara esto, tendría que hacer una función independiente que actuara como tal. Obviamente eso
sería poco óptimo, no podría lanzar ni capturar la excepción ya que como tal no lo es.

Quizá podría prescindir de excepciones, pero como en la función de SecondGrade es necesario retornar una lista
pensé que estaría guay solucionar el problema de la solución imaginaria con una excepción.

Si pruebas a no usar excepciones, cuando se dé una solución imaginaria se verá de la siguiente forma:
[NaN, NaN] (una lista con NotaNumber);
Obviamente, esto está feo.
*/

