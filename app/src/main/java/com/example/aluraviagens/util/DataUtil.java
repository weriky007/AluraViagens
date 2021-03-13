package com.example.aluraviagens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DD_MM = "dd/MM";

    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoData = new SimpleDateFormat(DD_MM);
        String dataIdaFormat = formatoData.format(dataIda.getTime());
        String dataVoltaFormat = formatoData.format(dataVolta.getTime());
        return dataIdaFormat + " - "
                + dataVoltaFormat + " de "
                + dataVolta.get(Calendar.YEAR);
    }

    //--------------------------------------------------------------------------------------------------
}
