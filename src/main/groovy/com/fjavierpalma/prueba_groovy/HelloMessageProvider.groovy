package com.fjavierpalma.prueba_groovy

class HelloMessageProvider {
    private Map messagesMap = [
            es: "Hola",
            en: "Hello",
            fr: "Salut"
    ]

    private String lang

    HelloMessageProvider(lang="es") {
        checkLang(lang)
        this.lang = lang
    }

    String getLang() {
        return lang;
    }

    HelloMessageProvider setLang(lang) {
        checkLang(lang)
        this.lang = lang
        return this
    }

    String getMessage(String name) {
        "${messagesMap[lang]} ${name}"
    }

    private void checkLang(String lang) throws LanguageNotFoundException {
        if (!messagesMap.containsKey(lang)) {
            throw new LanguageNotFoundException(lang)
        }
    }


}