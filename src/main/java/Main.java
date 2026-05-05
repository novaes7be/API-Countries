void main() {
    ClientHttp clientHttp = new ClientHttp();

    String jsonLanguagePort = clientHttp.getLanguage("Portuguese");
    CountryParser.parse(jsonLanguagePort);

    //String jsonLanguageEng = clientHttp.getLanguage("English");
    //CountryParser.parse(jsonLanguageEng);
}
