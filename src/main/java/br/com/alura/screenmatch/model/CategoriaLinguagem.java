package br.com.alura.screenmatch.model;

public enum CategoriaLinguagem {
    INGLES("English"),
    PORTUGUES("Portuguese"),
    ESPANHOL("Spanish"),
    GERMANICO("German"),
    ITALIADO("Italian"),
    LATIM("Latin"),
    GREGO("Greek");

    private String categoriaLinguagemOMDB;

    CategoriaLinguagem(String categoriaLingaugemOMDB){
        this.categoriaLinguagemOMDB = categoriaLingaugemOMDB;
    }

    public static CategoriaLinguagem fromString(String text){
        for(CategoriaLinguagem categoriaLinguagem : CategoriaLinguagem.values()){
            if(categoriaLinguagem.categoriaLinguagemOMDB.equalsIgnoreCase(text)){
                return categoriaLinguagem;
            }
        }
        throw new IllegalArgumentException("Nenhuma linguagem encontrata para a string fornecida: ");
    }

}
