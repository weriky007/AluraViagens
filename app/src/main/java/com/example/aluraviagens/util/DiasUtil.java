package com.example.aluraviagens.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataDiaTexto(int quantidadeDias) {
        if(quantidadeDias > 1){
            return  quantidadeDias + PLURAL;
        }
            return quantidadeDias + SINGULAR;
    }
}
