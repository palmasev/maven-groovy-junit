package com.fjavierpalma.prueba_groovy

class LanguageNotFoundException extends Exception {
    LanguageNotFoundException(String lang) {
        super("\"${lang}\" no es uno de los idiomas disponibles")
    }
}
