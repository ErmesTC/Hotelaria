package hotelaria;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Input {

    private static Scanner leitor = new Scanner(System.in);

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Scanner getLeitor() {
        return leitor;
    }

    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public static int nextInt() {
        while (true) {
            try {
                return Integer.parseInt(leitor.next());
            } catch (NumberFormatException e) {
                System.out.println("!!!Erro!!!VALOR INVÁLIDO!");
                System.out.println("Informe o valor Novamente:");
            }
        }
    }
    
    public static String next(boolean obrigatorio, int tmxMaximo) {
        String valor = leitor.next();
        while (true) {
            if (valor.isEmpty() || valor.isBlank()) {
                if(obrigatorio == false){
                    return valor;
                }
                System.out.println("!!Campo Obrigatorio!!");
                System.out.println("Informe Novamente: ");
            }
            else if(valor.length() > tmxMaximo){
                System.out.println("Este campo tem o tamanho de "+tmxMaximo);
                System.out.println("Informe Novamente: ");
            }
            else{
                return valor;
            }
        }
    }
    
    public static String next(boolean obrigatorio) {
        String valor = leitor.next();
        while (true) {
            if (!valor.isEmpty() || !valor.isBlank() || obrigatorio == false) {
                return valor;
            }
            else{
                System.out.println("!!Campo Obrigatório!!");
                System.out.println("Informe Novamente: ");
            }
        }
    }
    
    public static String nextLine(boolean obrigatorio) {
        while (true) {
            String valor = leitor.useDelimiter("\\n").next();
            if (!valor.isEmpty() || !valor.isBlank() || obrigatorio == false) {
                return valor;
            }
            else{
                System.out.println("!!Campo Obrigatório!!");
                System.out.println("Informe Novamente: ");
            }
        }
    }
    
    public static float nextFloat() {
        while (true) {
            try {
                return Float.parseFloat(leitor.next().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("!!!Erro!!!VALOR INVÁLIDO!");
                System.out.println("Informe o valor Novamente:");
            }
        }
    }

    public static double nextDouble() {
        while (true) {
            try {
                return Double.parseDouble(leitor.next());
            } catch (NumberFormatException e) {
                System.out.println("!!!Erro!!!VALOR INVÁLIDO!");
                System.out.println("Informe o valor Novamente:");
            }
        }
    }

    public static Date nextDate() {
        while (true) {
            String valor = "";
            valor = leitor.next();
            try {
                return dateFormat.parse(valor);
            } catch (ParseException ex) {
                System.out.println("!!!Erro!!!VALOR " + valor + " INVÁLIDO!");
                System.out.println("Informe o valor Novamente:");
            }
        }
    }

    public static String nextLine() {

        return leitor.useDelimiter("\\n").next();
    }

}