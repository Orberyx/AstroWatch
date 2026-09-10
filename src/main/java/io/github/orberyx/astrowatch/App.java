package io.github.orberyx.astrowatch;
import java.util.Date;
import java.util.Locale;

/**
 * Nota:
 * Deve ser pequeno e servir 
 * apenas pra chamar as outras funções
 * e as inicializar ao iniciar o programa
 * @author wendel
 */

public class App {
    public static void main(String[] args) {
        Date userTime = new Date();
        Locale userLang = Locale.getDefault();
        
        System.out.println("informações do Sistema:");
        
        System.out.println("Hora: " + userTime.toGMTString());
        System.out.println("Idioma: " + userLang);
    }
}
