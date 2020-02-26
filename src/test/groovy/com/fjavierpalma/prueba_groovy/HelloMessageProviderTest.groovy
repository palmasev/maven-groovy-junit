package com.fjavierpalma.prueba_groovy

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

import static org.junit.jupiter.api.Assertions.*

class HelloMessageProviderTest {

    private HelloMessageProvider helloMessageProvider;

    @Test
    void 'El idioma toma el valor por defecto con el constructor sin parámetros'() {
        helloMessageProvider = new HelloMessageProvider()

        assertEquals "es", helloMessageProvider.getLang()
    }

    @Test
    void 'El idioma se puede indicar en el constructor'() {
        helloMessageProvider = new HelloMessageProvider("en")

        assertEquals "en", helloMessageProvider.getLang()
    }

    @Test
    void 'El getter y setter del idioma funciona correctamente'() {
        helloMessageProvider = new HelloMessageProvider()

        assertEquals "fr", helloMessageProvider.setLang("fr").getLang()
    }

    @ParameterizedTest
    @CsvSource(["es,Hola Javier", "en,Hello Javier", "fr,Salut Javier"])
    void 'getMessage devuelve el saludo en función del idioma configurado'(String lang, String expected) {
        helloMessageProvider = new HelloMessageProvider(lang)

        assertEquals expected, helloMessageProvider.getMessage("Javier")
    }

    @Test
    void 'Si el idioma indicado en el constructor no existe se lanza una excepción'() {
        assertThrows LanguageNotFoundException.class, { new HelloMessageProvider('ru')}
    }

    @Test
    void 'Si el idioma indicado en el setter no existe se lanza una excepción'() {
        helloMessageProvider = new HelloMessageProvider()
        assertThrows LanguageNotFoundException.class, { helloMessageProvider.setLang("ru") }
    }
}
