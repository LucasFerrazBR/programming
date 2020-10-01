//Counter a number of times that a specific letter appears on a String

import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;

class Contador{
    public static void main(String [] args) throws IOException{
    Scanner entrada = new Scanner(new BufferedReader(new FileReader(args[0])));
    char letra = args[1].charAt(0);
    int contador = 0;
    String auxiliar;
    
    while (entrada.hasNext()){
        auxiliar = entrada.next();
        char[] conta = auxiliar.toCharArray();
        
        for (int i = 0; i < conta.length; i++){
            if (conta[i] == letra || conta[i] == Character.toUpperCase(letra)){
                contador++;
            } 
        }
    }
    System.out.println(contador);
    entrada.close();

    }
}
